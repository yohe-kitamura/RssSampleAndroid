package jp.co.pockeps.rsssample.view;

import jp.co.pockeps.rsssample.entity.Articles;

public interface UxMilkListView {

    void fetchData(Articles articles);

    void loadError();

}
