package cn.jsonlu.libs.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import cn.jsonlu.libs.service.BaseService;

/**
 * Author:JsonLu
 * DateTime:17/7/29 23:30
 * Email:luxd@sumpay.com
 * Desc:
 **/
public class BaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseService.getInstance().APP = getContext();
    }
}
