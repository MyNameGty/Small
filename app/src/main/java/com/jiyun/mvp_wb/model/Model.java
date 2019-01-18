package com.jiyun.mvp_wb.model;

import com.jiyun.mvp_wb.api.MyService;
import com.jiyun.mvp_wb.bean.LeiXingBean;
import com.jiyun.mvp_wb.bean.LieBiaoBean;
import com.jiyun.mvp_wb.presenter.Ipresenter;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Model implements Imodel{
    @Override
    public void getleixing(final Ipresenter.Click click, Map<String, Object> map) {
        Retrofit build = new Retrofit.Builder().baseUrl(MyService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        MyService myService = build.create(MyService.class);
        Observable<LeiXingBean> observable = myService.get_leixing(map);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LeiXingBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LeiXingBean leiXingBean) {
                        if(leiXingBean.getERRORCODE().equals("0")){
                            List<String> list = leiXingBean.getRESULT();
                            click.yes(leiXingBean.getRESULT());
                        }else{
                            click.no(leiXingBean.getERRORCODE());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getliebiao(final Ipresenter.Click click, Map<String, Object> map) {
        Retrofit build = new Retrofit.Builder().baseUrl(MyService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        MyService myService = build.create(MyService.class);
        Observable<LieBiaoBean> observable = myService.get_liebiao(map);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LieBiaoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LieBiaoBean lieBiaoBean) {
                        if(lieBiaoBean.getERRORCODE().equals("0")){

                            click.yes(lieBiaoBean.getRESULT());
                        }else{
                            click.no(lieBiaoBean.getERRORCODE());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
