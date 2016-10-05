package jp.co.pockeps.rsssample.view;

import java.util.List;

import jp.co.pockeps.rsssample.entity.uxmilk.Item;

public interface UxMilkListView {

    void fetchData(List<Item> items);

    void loadError();

}
