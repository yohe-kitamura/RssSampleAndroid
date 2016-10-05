package jp.co.pockeps.rsssmaple.repository;

import java.util.List;

import jp.co.pockeps.rsssmaple.entity.uxmilk.Channel;
import jp.co.pockeps.rsssmaple.entity.uxmilk.Item;
import jp.co.pockeps.rsssmaple.entity.uxmilk.UxMilkRss;

public abstract class MockUxMilkRepository extends UxMilkRepository {

    private static final String TAG = "UxMilkRepository";

    private List<Item> items;

    public MockUxMilkRepository(List<Item> items) {
        this.items = items;
    }

    /**
     * UxMilkRssを取得
     * @param listener コールバック用リスナー
     */
    public abstract void getUxMilkRss(final NetworkListener<UxMilkRss> listener);

    public void SuccessCase(NetworkListener<UxMilkRss> listener) {
        if (listener == null) {
            throw new IllegalArgumentException("listener should not null ");
        }

        UxMilkRss rss = new UxMilkRss();
        rss.channel = new Channel();
        rss.channel.items  = items;


        listener.onSuccess(rss);
    }

    public void failureCase(NetworkListener<UxMilkRss> listener){
        listener.onFailure();
    }
}
