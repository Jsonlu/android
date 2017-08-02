package cn.jsonlu.libs.activity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import cn.jsonlu.libs.service.BaseService;

/**
 * Author:JsonLu
 * DateTime:17/7/29 23:27
 * Email:luxd@sumpay.com
 * Desc:
 **/
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseService.getInstance().APP = this;
    }


}
