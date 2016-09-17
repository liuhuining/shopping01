package com.qf.liuyong.shopping01.task;

import android.os.AsyncTask;
import android.text.TextUtils;

import com.qf.liuyong.shopping01.bean.Clothers;
import com.qf.liuyong.shopping01.callback.TextCallBack;
import com.qf.liuyong.shopping01.parse.ParseUtils;
import com.qf.liuyong.shopping01.utils.OkHttpUtils;

import java.util.List;

/**
 * Created by Administrator on 2016/9/4 0004.
 */
public class MyStrTask extends AsyncTask<String,Void,String> {
    TextCallBack textCallBack;

    public MyStrTask(TextCallBack textCallBack) {
        this.textCallBack = textCallBack;
    }

    @Override
    protected String doInBackground(String... params) {
        OkHttpUtils utils = new OkHttpUtils();
            String httpStr = utils.doGetReq(params[0]);
            return httpStr;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (!TextUtils.isEmpty(s)){
            List<Clothers> list = ParseUtils.getClothersList(s);
            if (textCallBack != null){
                textCallBack.setOnTextCallBack(list);
            }
        }
    }
}
