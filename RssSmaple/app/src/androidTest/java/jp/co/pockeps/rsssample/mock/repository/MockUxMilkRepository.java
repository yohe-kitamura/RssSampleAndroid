package jp.co.pockeps.rsssample.mock.repository;

import android.support.annotation.NonNull;

import java.util.List;

import jp.co.pockeps.rsssample.entity.uxmilk.Channel;
import jp.co.pockeps.rsssample.entity.uxmilk.Item;
import jp.co.pockeps.rsssample.entity.uxmilk.UxMilkRss;
import jp.co.pockeps.rsssample.repository.NetworkListener;
import jp.co.pockeps.rsssample.repository.UxMilkRepository;

public abstract class MockUxMilkRepository extends UxMilkRepository {

    private final List<Item> items;

    protected MockUxMilkRepository(List<Item> items) {
        this.items = items;
    }

    /**
     * UxMilkRssを取得
     * @param listener コールバック用リスナー
     */
    public abstract void getUxMilkRss(@NonNull final NetworkListener<UxMilkRss> listener);

    protected void SuccessCase(NetworkListener<UxMilkRss> listener) {
        if (listener == null) {
            throw new IllegalArgumentException("listener should not null ");
        }

        UxMilkRss rss = new UxMilkRss();
        rss.channel = new Channel();
        rss.channel.items  = items;


        listener.onSuccess(rss);
    }

    protected void failureCase(NetworkListener<UxMilkRss> listener){
        listener.onFailure();
    }
}
