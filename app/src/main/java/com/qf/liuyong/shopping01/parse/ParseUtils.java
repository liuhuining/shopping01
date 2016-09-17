package com.qf.liuyong.shopping01.parse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qf.liuyong.shopping01.bean.Clothers;
import com.qf.liuyong.shopping01.bean.DetailClother;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2016/9/4 0004.
 */
public class ParseUtils {
    public static List<Clothers> getClothersList(String str){
        Type type = new TypeToken<List<Clothers>>(){}.getType();
        try {
            JSONObject jsonObject = new JSONObject(str);
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
            JSONArray jsonArray = jsonObject1.getJSONArray("items");
            Gson gson = new Gson();
            List<Clothers> list = gson.fromJson(jsonArray.toString(),type);
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
    public static List<DetailClother> getDetailClotherList(String str){
        Type type = new TypeToken<List<DetailClother>>(){}.getType();
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(str);
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
            JSONArray jsonArray = jsonObject1.getJSONArray("items");
            Gson gson = new Gson();
            List<DetailClother> detailClotherList = gson.fromJson(jsonArray.toString(),type);
            return detailClotherList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
