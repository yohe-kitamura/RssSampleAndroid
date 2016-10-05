package jp.co.pockeps.rsssmaple.presenter;

import javax.inject.Inject;

import jp.co.pockeps.rsssmaple.entity.uxmilk.UxMilkRss;
import jp.co.pockeps.rsssmaple.repository.NetworkListener;
import jp.co.pockeps.rsssmaple.repository.UxMilkRepository;
import jp.co.pockeps.rsssmaple.view.UxMilkListView;

public class UxMilkListPresenter implements NetworkListener<UxMilkRss> {

    private UxMilkListView view;

    UxMilkRepository repository;

    @Inject
    UxMilkListPresenter(UxMilkRepository repository) {
        this.repository = repository;
    }

    public void setView(UxMilkListView view){
        this.view = view;
    }

    /**
     * データ取得
     */
    public void loadDate(){
        repository.getUxMilkRss(this);
    }

    @Override
    public void onSuccess(UxMilkRss response) {
        view.fetchData(response.getItems());
    }

    @Override
    public void onFailure() {
        view.loadError();
    }

}
