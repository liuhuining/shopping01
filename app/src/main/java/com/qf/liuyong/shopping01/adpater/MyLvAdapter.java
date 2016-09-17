package com.qf.liuyong.shopping01.adpater;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.qf.liuyong.shopping01.R;
import com.qf.liuyong.shopping01.bean.Clothers;

import java.util.List;

/**
 * Created by Administrator on 2016/9/11 0011.
 */
public class MyLvAdapter extends BaseAdapter{
    List<Clothers> clothersList;
    Context context;
    private int pos = 0;

    public void setPos(int pos) {
        this.pos = pos;
    }

    public MyLvAdapter(List<Clothers> clothersList, Context context) {
        this.clothersList = clothersList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return clothersList.size();
    }

    @Override
    public Clothers getItem(int position) {
        return clothersList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.lv_items,null,false);
        TextView textView = (TextView) convertView.findViewById(R.id.lv_tv);
        textView.setText(clothersList.get(position).getComponent().getTitle());
        if (pos == position){
            convertView.setBackgroundColor(Color.RED);
        }else {
            convertView.setBackgroundColor(Color.WHITE);
        }

        return convertView;
    }
}
