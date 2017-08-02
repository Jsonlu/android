package cn.jsonlu.demo.services.https;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.IOException;

import cn.jsonlu.demo.framework.App;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Author:JsonLu
 * DateTime:17/2/16 23:01
 * Email:jsonlu@qq.com
 * Desc:Http拦截器&&网路路由调度
 **/
public class HttpInterceptor implements Interceptor {


    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (!isNetworkAvailable(App.CONTEXT)) {
            request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
        }
        long t1 = System.nanoTime();
        Response response = chain.proceed(request);
        long t2 = System.nanoTime();
        Log.i("网络日志", String.format("Request header=%s Received response for %s in %.1fms%n%s", new Object[]{request.headers(), response.request().url(), Double.valueOf((double) (t2 - t1) / 1000000.0D), response.headers()}));
        return response;
    }

    private boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }
}
