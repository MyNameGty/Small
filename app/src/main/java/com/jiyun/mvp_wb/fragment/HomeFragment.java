package com.jiyun.mvp_wb.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.mvp_wb.R;
import com.jiyun.mvp_wb.adapter.MyAdapter;
import com.jiyun.mvp_wb.bean.LieBiaoBean;
import com.jiyun.mvp_wb.presenter.Ipresenter;
import com.jiyun.mvp_wb.presenter.Presenter;
import com.jiyun.mvp_wb.view.Iview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressLint("ValidFragment")
public class HomeFragment extends Fragment implements Iview {
    private String cate;
    private List<LieBiaoBean.RESULTBean> newlist;
    private List<LieBiaoBean.RESULTBean> list = new ArrayList<>();
    private XRecyclerView xrv;
    private Ipresenter ipresenter;
    public HomeFragment(String cate) {
        this.cate = cate;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_layout, null);
        xrv = (XRecyclerView) view.findViewById(R.id.xrv);
        initext();
        return view;
    }

    private void initext() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("appKey","3796ef9ea1ab46c7bee1f4d00fa8495a");
        map.put("queryType",cate);
        ipresenter = new Presenter(this);
        ipresenter.liebiao(map);
    }

    @Override
    public void show(Object result) {
        newlist = (List<LieBiaoBean.RESULTBean>) result;
        list.addAll(newlist);
        MyAdapter myAdapter = new MyAdapter(list,getContext());
        xrv.setLayoutManager(new LinearLayoutManager(getContext()));
        xrv.setAdapter(myAdapter);
    }

    @Override
    public void no(String ting) {
        Toast.makeText(getContext(), ting, Toast.LENGTH_SHORT).show();
    }
}
