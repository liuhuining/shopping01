package com.qf.liuyong.shopping01.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.qf.liuyong.shopping01.R;
import com.qf.liuyong.shopping01.adpater.MyDetailAdapter;
import com.qf.liuyong.shopping01.bean.DetailClother;
import com.qf.liuyong.shopping01.parse.ParseUtils;
import com.qf.liuyong.shopping01.utils.OkHttpUtils;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

public class DetailActivity extends AppCompatActivity {
    String path = "";
    GridView gridView;
    List<DetailClother> detailClotherList;
    MyDetailAdapter adapter;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg!=null){
                if (msg.what == 0){
                    detailClotherList = (List<DetailClother>) msg.obj;
                    adapter = new MyDetailAdapter(detailClotherList,DetailActivity.this);
                    gridView.setAdapter(adapter);

                    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            String idWeb = detailClotherList.get(position).getComponent().getAction().getSourceId();
                            Intent intent = new Intent(DetailActivity.this,ThirdActivity.class);
                            intent.putExtra("id",idWeb);
                            startActivity(intent);
                        }
                    });

                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("列表详情");
        gridView = (GridView) findViewById(R.id.gridView);
        Intent intent = getIntent();
        String detail = intent.getStringExtra("detail");
        Log.e("====","==url=="+detail);
        try {
            String url = URLEncoder.encode(detail,"utf-8");
            String url1 = URLDecoder.decode(url,"utf-8");
            Log.e("====","==url=="+url);
            Log.e("====","==url1=="+url1);
            path = "http://api-v2.mall.hichao.com/search/skus?" +
                    "query="+url1+"+20%20" +
                    "&sort=all&ga=%252Fsearch%252Fskus&flag=&cat=&asc=1";
            new Thread(new Runnable() {
                @Override
                public void run() {
                    OkHttpUtils okHttpUtils = new OkHttpUtils();
                    String string = okHttpUtils.doGetReq(path);
                    List<DetailClother> detailClotherList = ParseUtils.getDetailClotherList(string);
                    handler.obtainMessage(0,detailClotherList).sendToTarget();
                }
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
