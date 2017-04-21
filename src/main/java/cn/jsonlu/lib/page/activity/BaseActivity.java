package cn.jsonlu.lib.page.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import cn.jsonlu.lib.R;

/**
 * Author:JsonLu
 * DateTime:17/3/9 18:50
 * Email:jsonlu@qq.com
 * Desc:
 **/
public class BaseActivity extends AppCompatActivity {

    protected Toolbar toolbar;
    protected TextView title;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar = (Toolbar) findViewById(R.id.id_tool_bar);
        title = (TextView) findViewById(R.id.title);
        setSupportActionBar(toolbar);
    }

    public void onClick(View view) {
        if (view.getId() == android.support.v7.appcompat.R.id.home) {
            finish();
        }
    }

}
