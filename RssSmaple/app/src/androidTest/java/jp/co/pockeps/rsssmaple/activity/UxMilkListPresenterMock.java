package jp.co.pockeps.rsssmaple.activity;

import java.util.Collections;

import jp.co.pockeps.rsssmaple.entity.uxmilk.Item;
import jp.co.pockeps.rsssmaple.entity.uxmilk.UxMilkRss;
import jp.co.pockeps.rsssmaple.repository.NetworkListener;
import jp.co.pockeps.rsssmaple.view.UxMilkListView;


public class UxMilkListPresenterMock implements NetworkListener<UxMilkRss> {

    public boolean isSuccess = true;
    private UxMilkListView view;

    public UxMilkListPresenterMock(UxMilkListView view) {
        this.view = view;
    }

    public void loadDate() {
        if (isSuccess) {
            onSuccess(null);
        } else {
            onFailure();
        }
    }

    @Override
    public void onSuccess(UxMilkRss response) {
        Item item = new Item();
        item.title = "タイトル";
        item.pubDate = "Thu, 29 Sep 2016 22:30:55 +0000";
        item.description = "説明";
        view.fetchData(Collections.singletonList(item));
    }

    @Override
    public void onFailure() {
        view.loadError();
    }
}