package jp.co.pockeps.rsssmaple.network;

import jp.co.pockeps.rsssmaple.entity.uxmilk.UxMilkRss;

import retrofit2.Response;
import retrofit2.http.GET;
import rx.Observable;

public interface UxMilkService {
    /**
     * Rss取得
     * @return Rss取得用Observable
     */
    @GET("/feed")
    public Observable<Response<UxMilkRss>> get();
}
