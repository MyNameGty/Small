package com.jiyun.mvp_wb.model;

import com.jiyun.mvp_wb.presenter.Ipresenter;

import java.util.Map;

public interface Imodel {
    void getleixing(Ipresenter.Click click, Map<String,Object>map);
    void getliebiao(Ipresenter.Click click,Map<String,Object>map);
}
