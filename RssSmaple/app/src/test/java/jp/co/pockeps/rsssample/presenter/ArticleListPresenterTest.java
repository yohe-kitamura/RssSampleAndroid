package jp.co.pockeps.rsssample.presenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.*;

import jp.co.pockeps.rsssample.entity.Articles;
import jp.co.pockeps.rsssample.presentation.presenter.ArticleListPresenter;
import jp.co.pockeps.rsssample.repository.NetworkListener;
import jp.co.pockeps.rsssample.repository.UxMilkRepository;
import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.schedulers.Schedulers;

import static org.mockito.Matchers.*;

@SuppressWarnings("unchecked")
@RunWith(JUnit4.class)
public class ArticleListPresenterTest {

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
        ArticleListPresenter presenter = new ArticleListPresenter(repository);

        presenter.loadDate();

        Mockito.verify(repository, Mockito.times(1)).getUxMilkRss((NetworkListener<Articles>) any());
    }

}