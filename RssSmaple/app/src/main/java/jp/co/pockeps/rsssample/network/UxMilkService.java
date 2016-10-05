package jp.co.pockeps.rsssample.network;

import jp.co.pockeps.rsssample.entity.uxmilk.UxMilkRss;
import retrofit2.Response;
import retrofit2.http.GET;
import rx.Observable;

public interface UxMilkService {
    /**
     * Rss取得
     *
     * @return Rss取得用Observable
     */
    @GET("/feed")
    Observable<Response<UxMilkRss>> get();
}
