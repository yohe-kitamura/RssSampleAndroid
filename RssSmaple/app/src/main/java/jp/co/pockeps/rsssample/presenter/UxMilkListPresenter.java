package jp.co.pockeps.rsssample.presenter;

import android.support.annotation.Nullable;

import javax.inject.Inject;

import jp.co.pockeps.rsssample.entity.uxmilk.UxMilkRss;
import jp.co.pockeps.rsssample.repository.NetworkListener;
import jp.co.pockeps.rsssample.repository.UxMilkRepository;
import jp.co.pockeps.rsssample.view.UxMilkListView;

public class UxMilkListPresenter implements NetworkListener<UxMilkRss> {

    @SuppressWarnings("WeakerAccess") final UxMilkRepository repository;
    @Nullable private UxMilkListView view;

    @Inject
    UxMilkListPresenter(UxMilkRepository repository) {
        this.repository = repository;
    }

    public void setView(@Nullable UxMilkListView view) {
        this.view = view;
    }

    /**
     * データ取得
     */
    public void loadDate() {
        repository.getUxMilkRss(this);
    }

    @Override
    public void onSuccess(UxMilkRss response) {
        if (view != null) {
            view.fetchData(response.getItems());
        }
    }

    @Override
    public void onFailure() {
        if (view != null) {
            view.loadError();
        }
    }

}
