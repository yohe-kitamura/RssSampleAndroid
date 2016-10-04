package jp.co.pockeps.rsssmaple.view;

import java.util.List;

import jp.co.pockeps.rsssmaple.entity.uxmilk.Item;

public interface UxMilkListView {

    void fetchData(List<Item> items);

    void loadError();

}
