package cn.jsonlu.lib;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Author:JsonLu
 * DateTime:17/5/10 10:53
 * Email:jsonlu@qq.com
 * Desc:
 **/
public class NetInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        request.newBuilder().addHeader("osType", "A")
                .addHeader("appVersion", "4.0.1")
                .addHeader("appCode", "401")
                .addHeader("jsVersion", "1001")
                .addHeader("appChanel", "com")
                .addHeader("Content-Type", "application/x-www-form-urlencoded").build();
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
