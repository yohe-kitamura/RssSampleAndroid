package jp.co.pockeps.rsssmaple.presenter;

import jp.co.pockeps.rsssmaple.entity.uxmilk.UxMilkRss;
import jp.co.pockeps.rsssmaple.repository.NetworkListener;
import jp.co.pockeps.rsssmaple.repository.UxMilkRepository;
import jp.co.pockeps.rsssmaple.view.UxMilkListView;

public class UxMilkListPresenter implements NetworkListener<UxMilkRss> {

    private UxMilkListView view;

    public UxMilkListPresenter(UxMilkListView view) {
        this.view = view;
    }

    /**
     * データ取得
     */
    public void loadDate(){
        UxMilkRepository repository = createMilkRepository();
        repository.getUxMilkRss(this);
    }

    /**
     * UxMilkRepositoryのFactoryメソッド
     * @return UxMilkRepository
     */
    private UxMilkRepository createMilkRepository(){
        return new UxMilkRepository();
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
