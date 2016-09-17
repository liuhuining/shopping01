package com.qf.liuyong.shopping01.adpater;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.qf.liuyong.shopping01.R;
import com.qf.liuyong.shopping01.bean.DetailClother;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/9/16.
 */
public class MyDetailAdapter extends BaseAdapter {
    List<DetailClother> detailClothers;
    Context context;

    public MyDetailAdapter(List<DetailClother> detailClothers, Context context) {
        this.detailClothers = detailClothers;
        this.context = context;
    }

    @Override
    public int getCount() {
        return detailClothers.size();
    }

    @Override
    public DetailClother getItem(int position) {
        return detailClothers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder  viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.gv_detail,null,false);
            viewHolder = new ViewHolder(convertView);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_describe.setText(detailClothers.get(position).getComponent().getDescription());
        viewHolder.tv_current_price.setText(detailClothers.get(position).getComponent().getPrice());
        viewHolder.tv_cost_price.setText(detailClothers.get(position).getComponent().getOrigin_price());
        viewHolder.tv_cost_price.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        viewHolder.tv_sales.setText(detailClothers.get(position).getComponent().getSales());
        Picasso.with(context).load(detailClothers.get(position).getComponent().getPicUrl()).
                placeholder(R.mipmap.ic_launcher).into(viewHolder.iv_detail);
        return convertView;
    }
    class ViewHolder{
        ImageView iv_detail;
        TextView tv_describe;
        TextView tv_current_price;
        TextView tv_cost_price;
        TextView tv_sales;
        View itemView;

        public ViewHolder(View itemView) {
            this.itemView = itemView;
            iv_detail = (ImageView) itemView.findViewById(R.id.iv_detail);
            tv_describe = (TextView) itemView.findViewById(R.id.tv_describe);
            tv_cost_price = (TextView) itemView.findViewById(R.id.tv_cost_price);
            tv_current_price = (TextView) itemView.findViewById(R.id.tv_current_price);
            tv_sales = (TextView) itemView.findViewById(R.id.tv_sales);
            itemView.setTag(this);
        }
    }
}
