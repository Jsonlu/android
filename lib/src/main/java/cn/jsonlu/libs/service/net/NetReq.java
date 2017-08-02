package cn.jsonlu.libs.service.net;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cn.jsonlu.libs.data.param.BaseParam;
import cn.jsonlu.libs.data.vo.BaseVo;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Author:JsonLu
 * DateTime:17/5/10 10:54
 * Email:jsonlu@qq.com
 * Desc:
 **/
public class NetReq {
    private final static OkHttpClient HTTP_CLIENT = new OkHttpClient.Builder().connectTimeout(5, TimeUnit.SECONDS).addInterceptor(new NetInterceptor()).build();
    private final MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");

    public String sendReq(String api, String param) {
        String url = api.startsWith("http") || api.startsWith("https") ? api : (String.format("%s%s", Host.Host, api));
        RequestBody body = RequestBody.create(mediaType, param);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try {
            Response response = HTTP_CLIENT.newCall(request).execute();
            if (response.isSuccessful())
                return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T extends BaseVo> T sendReq(String api, Class<? extends BaseParam> param, TypeReference<T> type) {
        String data = sendReq(api, param.toString());
        return data != null ? JSON.parseObject(data, type) : null;
    }

}
