package jp.co.pockeps.rsssample.repository;

import android.support.annotation.NonNull;

import jp.co.pockeps.rsssample.entity.uxmilk.UxMilkRss;
import jp.co.pockeps.rsssample.network.UxMilkService;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static jp.co.pockeps.rsssample.Constant.Url.UX_MILK;

public class UxMilkRepository {

    /**
     * UxMilkRssを取得
     *
     * @param listener コールバック用リスナー
     */
    public void getUxMilkRss(@NonNull final NetworkListener<UxMilkRss> listener) {

        //Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UX_MILK)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        //Rx
        UxMilkService uxMilkService = retrofit.create(UxMilkService.class);
        uxMilkService.get().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io()).subscribe(new Subscriber<Response<UxMilkRss>>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                listener.onFailure();
            }

            @Override
            public void onNext(Response<UxMilkRss> uxMilkRssResponse) {
                listener.onSuccess(uxMilkRssResponse.body());
            }
        });
    }
}
