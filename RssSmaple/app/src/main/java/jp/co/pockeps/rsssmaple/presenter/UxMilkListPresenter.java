package jp.co.pockeps.rsssmaple.presenter;

import android.widget.Toast;

import jp.co.pockeps.rsssmaple.entity.uxmilk.UxMilkRss;
import jp.co.pockeps.rsssmaple.repository.NetworkListener;
import jp.co.pockeps.rsssmaple.repository.UxMilkRepository;
import jp.co.pockeps.rsssmaple.view.UxMilkListView;
import retrofit2.Response;

public class UxMilkListPresenter implements NetworkListener<UxMilkRss> {

    private UxMilkListView view;

    public UxMilkListPresenter(UxMilkListView view) {
        this.view = view;
    }

    public void loadDate(){
        UxMilkRepository repository = createMilkRepository();
        repository.getUxMilkRss(this);
    }

    private UxMilkRepository createMilkRepository(){
        return new UxMilkRepository();
    }

    @Override
    public void OnSuccess(Response<UxMilkRss> response) {
        view.fetchData(response.body().getItems());
    }

    @Override
    public void onFailure() {
        view.loadError();
    }

}
