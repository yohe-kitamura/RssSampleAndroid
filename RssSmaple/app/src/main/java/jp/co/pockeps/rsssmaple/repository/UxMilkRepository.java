package jp.co.pockeps.rsssmaple.repository;

import android.util.Log;

import jp.co.pockeps.rsssmaple.entity.uxmilk.UxMilkRss;
import jp.co.pockeps.rsssmaple.network.UxMilkService;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static jp.co.pockeps.rsssmaple.Constant.Url.UX_MILK;

public class UxMilkRepository {

    private static final String TAG = "UxMilkRepository";

    public void getUxMilkRss(final NetworkListener<UxMilkRss> listener) {

        if (listener == null) {
            throw new IllegalArgumentException("listener should not null ");
        }

        //Retrofitビルド
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UX_MILK)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        UxMilkService uxMilkService = retrofit.create(UxMilkService.class);
        uxMilkService.get().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io()).subscribe(new Subscriber<Response<UxMilkRss>>() {
            @Override
            public void onCompleted() {
                Log.e(TAG, "onCompleted: ");
            }

            @Override
            public void onError(Throwable e) {
                listener.onFailure();
            }

            @Override
            public void onNext(Response<UxMilkRss> uxMilkRssResponse) {
                listener.OnSuccess(uxMilkRssResponse);
            }
        });
    }
}
