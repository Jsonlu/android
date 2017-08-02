package cn.jsonlu.demo.page.activity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

import cn.jsonlu.lib.R;
import cn.jsonlu.libs.Mobile;
import cn.jsonlu.libs.data.param.BaseParam;
import cn.jsonlu.libs.service.net.RxRequest;
import cn.jsonlu.libs.service.net.UserModel;

public class MainActivity extends BaseActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        UserModel model = new UserModel();
        RxRequest da = new RxRequest<Mobile, BaseParam>() {
            @Override
            public void call(Mobile D) {
                textView.append(D.toString());
            }
        };
        model.doSomething(Mobile.class, da);

    }
}
