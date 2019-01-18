package com.jiyun.mvp_wb.presenter;

import java.util.Map;

public interface Ipresenter {
    void leixing(Map<String,Object> map);
    void liebiao(Map<String,Object> map);
    interface Click<T>{
        void yes(T result);
        void no(String ting);
    }
}
