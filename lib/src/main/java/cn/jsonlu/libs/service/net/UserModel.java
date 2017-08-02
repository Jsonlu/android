package cn.jsonlu.libs.service.net;

import android.support.annotation.NonNull;

import cn.jsonlu.libs.data.vo.BaseVo;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 *
 */
public class UserModel {


    public <T extends BaseVo> void doSomething(final Class<T> tClass, final RxRequest rxRequest) {
        rxRequest.getRxInterceptor().start();
        Observable.create(new ObservableOnSubscribe<Response>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Response> e) throws Exception {
                final MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
                RequestBody body = RequestBody.create(mediaType, rxRequest.getRxInterceptor().process(rxRequest.getData()));
                Request.Builder builder = new Request.Builder()
                        .url("http://api.avatardata.cn/MobilePlace/LookUp?key=ec47b85086be4dc8b5d941f5abd37a4e&mobileNumber=13021671512")
                        .method("POST", body);
                Request request = builder.build();
                Call call = new OkHttpClient().newCall(request);
                Response response = call.execute();
                e.onNext(response);
            }
        }).map(new Function<Response, T>() {
            @Override
            public T apply(@NonNull Response response) throws Exception {
                if (response.isSuccessful()) {
                    ResponseBody body = response.body();
                    if (body != null) {
                        return rxRequest.getRxInterceptor().process(body.string(), tClass);
                    }
                }
                return null;
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<T>() {
                    @Override
                    public void accept(@NonNull T s) throws Exception {
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<T>() {
                    @Override
                    public void accept(@NonNull T data) throws Exception {
                        rxRequest.call(data);
                        rxRequest.getRxInterceptor().stop();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        rxRequest.getRxInterceptor().stop();
                    }
                });
    }

}
