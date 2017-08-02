package cn.jsonlu.demo.component;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import cn.jsonlu.lib.R;

/**
 * Author:JsonLu
 * DateTime:17/3/9 19:33
 * Email:jsonlu@qq.com
 * Desc:
 **/
public class Toolbar extends android.support.v7.widget.Toolbar {

    public TextView title;

    public Toolbar(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.toolbar, this);
        title = (TextView) findViewById(R.id.title);
    }

    public Toolbar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.toolbar, this);
        title = (TextView) findViewById(R.id.title);
    }

    public Toolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.toolbar, this);
        title = (TextView) findViewById(R.id.title);
    }
}
