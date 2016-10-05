package jp.co.pockeps.rsssmaple.presenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.*;

import jp.co.pockeps.rsssmaple.entity.uxmilk.UxMilkRss;
import jp.co.pockeps.rsssmaple.repository.NetworkListener;
import jp.co.pockeps.rsssmaple.repository.UxMilkRepository;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.schedulers.Schedulers;

import static org.mockito.Matchers.*;

@SuppressWarnings("unchecked")
@RunWith(JUnit4.class)
public class UxMilkListPresenterTest {

    @Before
    public void setUp() throws Exception {
        RxAndroidPlugins.getInstance().registerSchedulersHook(new RxAndroidSchedulersHook() {
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        });
    }

    @After
    public void tearDown() {
        RxAndroidPlugins.getInstance().reset();
    }

    @Test
    public void loadDate() throws Exception {
        UxMilkRepository repository = Mockito.spy(new UxMilkRepository());
        UxMilkListPresenter presenter = new UxMilkListPresenter(repository);

        presenter.loadDate();

        Mockito.verify(repository, Mockito.times(1)).getUxMilkRss((NetworkListener<UxMilkRss>) any());
    }

}