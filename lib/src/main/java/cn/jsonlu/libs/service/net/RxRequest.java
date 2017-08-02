package cn.jsonlu.libs.service.net;

import com.alibaba.fastjson.JSON;

import cn.jsonlu.libs.data.param.BaseParam;
import cn.jsonlu.libs.data.vo.BaseVo;

/**
 * Author:JsonLu
 * DateTime:17/7/31 17:43
 * Email:luxd@sumpay.com
 * Desc:
 **/
public abstract class RxRequest<T extends BaseVo, S extends BaseParam> {


    private S Data = null;

    public abstract void call(T D);


    public S getData() {
        if (Data == null)
            return (S) new BaseParam();
        return Data;
    }

    public RxRequest setData(S data) {
        Data = data;
        return this;
    }

    public RxInterceptor getRxInterceptor() {
        return defaults;
    }


    public static volatile RxInterceptor defaults = new RxInterceptor() {
        @Override
        public void start() {

        }

        @Override
        public <T extends BaseParam> String process(T t) {
            return JSON.toJSONString(t);
        }

        @Override
        public <S extends BaseVo> S process(String t, Class<? extends S> cls) {
            return JSON.parseObject(t, cls);
        }

        @Override
        public void stop() {

        }
    };
}
