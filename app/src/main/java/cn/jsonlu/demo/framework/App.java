package cn.jsonlu.demo.framework;

import android.app.Application;
import android.content.Context;

/**
 * Author:JsonLu
 * DateTime:17/3/9 19:25
 * Email:jsonlu@qq.com
 * Desc:
 **/
public class App extends Application{
    public static Context CONTEXT;

    @Override
    public void onCreate() {
        super.onCreate();
        CONTEXT = this;
    }
}
