package com.qf.liuyong.shopping01.activity;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.qf.liuyong.shopping01.R;
import com.qf.liuyong.shopping01.adpater.MyGvAdapter;
import com.qf.liuyong.shopping01.adpater.MyLvAdapter;
import com.qf.liuyong.shopping01.bean.Clothers;
import com.qf.liuyong.shopping01.callback.TextCallBack;
import com.qf.liuyong.shopping01.fragment.ContentFragment;
import com.qf.liuyong.shopping01.fragment.NavifationFragment;
import com.qf.liuyong.shopping01.task.MyStrTask;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("首页");
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content,new ContentFragment()).commit();
        fragmentManager.beginTransaction().replace(R.id.left,new NavifationFragment()).commit();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,drawerLayout,R.string.app_name,R.string.app_name
        );
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                if (drawerLayout.isDrawerOpen(Gravity.LEFT)){
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }else{
                    drawerLayout.openDrawer(Gravity.LEFT);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
