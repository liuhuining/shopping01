package com.qf.liuyong.shopping01.adpater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.liuyong.shopping01.R;
import com.qf.liuyong.shopping01.bean.Clothers;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/9/11 0011.
 */
public class MyGvAdapter extends BaseAdapter {
    List<Clothers.ComponentBeans.ItemsBean> gvClothersList;
    Context context;

    public MyGvAdapter(List<Clothers.ComponentBeans.ItemsBean> gvClothersList, Context context) {
        this.gvClothersList = gvClothersList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return gvClothersList.size();
    }

    @Override
    public Clothers.ComponentBeans.ItemsBean getItem(int position) {
        return gvClothersList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.gv_items,null,false);
            viewHolder  = new ViewHolder(convertView);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(gvClothersList.get(position).getComponent().getWord());
        Picasso.with(context).load(gvClothersList.get(position).getComponent().getPicUrl()).placeholder(R.mipmap.ic_launcher).into(viewHolder.img);
        return convertView;
    }
    class ViewHolder{
        ImageView img;
        TextView textView;
        View itemView;

        public ViewHolder(View itemView) {
            this.itemView = itemView;
            img = (ImageView) itemView.findViewById(R.id.gv_image);
            textView = (TextView) itemView.findViewById(R.id.gv_tv);
            itemView.setTag(this);
        }
    }
}
