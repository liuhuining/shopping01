package com.qf.liuyong.shopping01.utils;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/9/4 0004.
 */
public class OkHttpUtils {
    private OkHttpClient client;
    public OkHttpUtils(){
        client = new OkHttpClient();
    }
    public String doGetReq(String url) {
        Request request = new Request.Builder().url(url).build();
        Response res = null;
        try {
            res = client.newCall(request).execute();
            return res.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
