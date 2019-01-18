package com.jiyun.mvp_wb.api;

import com.jiyun.mvp_wb.bean.LeiXingBean;
import com.jiyun.mvp_wb.bean.LieBiaoBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

public interface MyService {
    String url = "http://api.shujuzhihui.cn/api/weibo/";

    @GET("list")
    Observable<LieBiaoBean>get_liebiao(@QueryMap Map<String,Object>map);


    @GET("type")

    Observable<LeiXingBean>get_leixing(@QueryMap Map<String,Object>map);
}
