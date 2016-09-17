package com.qf.liuyong.shopping01.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.qf.liuyong.shopping01.R;
import com.qf.liuyong.shopping01.activity.DetailActivity;
import com.qf.liuyong.shopping01.adpater.MyGvAdapter;
import com.qf.liuyong.shopping01.adpater.MyLvAdapter;
import com.qf.liuyong.shopping01.bean.Clothers;
import com.qf.liuyong.shopping01.callback.TextCallBack;
import com.qf.liuyong.shopping01.task.MyStrTask;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends Fragment implements TextCallBack{

    String url = "http://api-v2.mall.hichao.com/category/list?ga=%2Fcategory%2Flist";
    MyLvAdapter myLvAdapter;
    MyGvAdapter myGvAdapter;
    ListView listView;
    GridView gridView;
    List<Clothers.ComponentBeans.ItemsBean> gvlist;
    List<Clothers> list;

    public ContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_content, container, false);

        listView = (ListView) view.findViewById(R.id.lv);
        gridView = (GridView) view.findViewById(R.id.gv);
        new MyStrTask(this).execute(url);
        return view;
    }

    @Override
    public void setOnTextCallBack(final List<Clothers> list) {
        if (list!=null && list.size()>0) {
            myLvAdapter = new MyLvAdapter(list, getContext());
            myLvAdapter.setPos(0);
            listView.setAdapter(myLvAdapter);
            myGvAdapter = new MyGvAdapter(list.get(0).getComponent().getItems(), getContext());
            gridView.setAdapter(myGvAdapter);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position1, long id) {
                            String detail = list.get(0).getComponent().getItems().get(position1).getComponent().getWord();
                            Intent intent = new Intent(getActivity(), DetailActivity.class);
                            intent.putExtra("detail", detail);
                            startActivity(intent);
                        }
                    });
                }
            });
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                int i = 0;

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    gvlist = list.get(position).getComponent().getItems();
                    myGvAdapter = new MyGvAdapter(gvlist, getActivity());
                    myLvAdapter.setPos(position);
                    myLvAdapter.notifyDataSetInvalidated();
                    gridView.setAdapter(myGvAdapter);
                    i = position;
                    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position1, long id) {
                            String detail = list.get(i).getComponent().getItems().get(position1).getComponent().getWord();
                            Intent intent = new Intent(getActivity(), DetailActivity.class);
                            intent.putExtra("detail", detail);
                            startActivity(intent);
                        }
                    });

                }
            });
        }
    }
}
