package cn.jsonlu.libs.service.net;

import cn.jsonlu.libs.data.param.BaseParam;
import cn.jsonlu.libs.data.vo.BaseVo;

/**
 * Author:JsonLu
 * DateTime:17/8/1 17:25
 * Email:luxd@sumpay.com
 * Desc:转换拦截器
 **/
public interface RxInterceptor {
    //开始操作
    void start();

    //请求数据转换
    <T extends BaseParam> String process(T t);

    //返回数据转换
    <S extends BaseVo> S process(String t, Class<? extends S> cls);

    //终止操作
    void stop();

}
