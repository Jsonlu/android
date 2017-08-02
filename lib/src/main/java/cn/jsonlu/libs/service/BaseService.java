package cn.jsonlu.libs.service;

import android.content.Context;

/**
 * Author:JsonLu
 * DateTime:17/7/29 23:11
 * Email:luxd@sumpay.com
 * Desc:
 **/
public class BaseService {

    private static volatile BaseService instance = null;

    public static BaseService getInstance() {
        if (null == instance) {
            synchronized (BaseService.class) {
                if (null == instance)
                    instance = new BaseService();
            }
        }
        return instance;
    }

    public Context APP;
}
