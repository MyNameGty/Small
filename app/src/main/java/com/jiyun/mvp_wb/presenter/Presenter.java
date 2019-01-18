package com.jiyun.mvp_wb.presenter;

import com.jiyun.mvp_wb.model.Imodel;
import com.jiyun.mvp_wb.model.Model;
import com.jiyun.mvp_wb.view.Iview;

import java.util.Map;

public class Presenter implements Ipresenter,Ipresenter.Click{
    private Iview iview;
    private Imodel imodel;

    public Presenter(Iview iview) {
        this.iview = iview;
        imodel = new Model();
    }

    @Override
    public void leixing(Map<String,Object> map) {
        imodel.getleixing(this,map);
    }

    @Override
    public void liebiao(Map<String,Object> map) {
        imodel.getliebiao(this,map);
    }

    @Override
    public void yes(Object result) {
        if(iview!=null){
            iview.show(result);
        }
    }

    @Override
    public void no(String ting) {
        if(iview!=null){
            iview.no(ting);
        }
    }
}
