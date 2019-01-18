package com.jiyun.mvp_wb.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.mvp_wb.R;
import com.jiyun.mvp_wb.bean.LieBiaoBean;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {
    private List<LieBiaoBean.RESULTBean> list;
    private Context context;

    public MyAdapter(List<LieBiaoBean.RESULTBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, null);
        MyViewHolder mvh = new MyViewHolder(view);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(viewHolder instanceof MyViewHolder){
            MyViewHolder mvh = (MyViewHolder) viewHolder;
            mvh.title.setText(list.get(i).getTitle());
            mvh.scer.setText(list.get(i).getBlogger());
            Glide.with(context).load(list.get(i).getImg_list().get(0)).into(mvh.img);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView img;
        public TextView title;
        public TextView scer;

        public MyViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img = (ImageView) rootView.findViewById(R.id.img);
            this.title = (TextView) rootView.findViewById(R.id.title);
            this.scer = (TextView) rootView.findViewById(R.id.scer);
        }

    }
}
