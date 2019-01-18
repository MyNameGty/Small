package com.jiyun.mvp_wb;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.jiyun.mvp_wb.adapter.OneAdapter;
import com.jiyun.mvp_wb.bean.LeiXingBean;
import com.jiyun.mvp_wb.fragment.HomeFragment;
import com.jiyun.mvp_wb.presenter.Ipresenter;
import com.jiyun.mvp_wb.presenter.Presenter;
import com.jiyun.mvp_wb.view.Iview;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements Iview {

    private TabLayout tab;
    private ViewPager vp;
    private Ipresenter ipresenter;
    private ArrayList<Fragment>list_fra = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initext();
    }

    private void initView() {
        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);
        tab.setupWithViewPager(vp);
    }
    private void initext(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("appKey","3796ef9ea1ab46c7bee1f4d00fa8495a");
        ipresenter = new Presenter(this);
        ipresenter.leixing(map);
    }
    @Override
    public void show(Object result) {
       ArrayList<String>list = (ArrayList<String>) result;
        for (int i = 0; i < list.size(); i++) {
            HomeFragment homeFragment = new HomeFragment(list.get(i));
            list_fra.add(homeFragment);
        }
        OneAdapter oneAdapter = new OneAdapter(getSupportFragmentManager(), list, list_fra);
        vp.setAdapter(oneAdapter);
    }

    @Override
    public void no(String ting) {
        Toast.makeText(this, ting, Toast.LENGTH_SHORT).show();
    }
}
