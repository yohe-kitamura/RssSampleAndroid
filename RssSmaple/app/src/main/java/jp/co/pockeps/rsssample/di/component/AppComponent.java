package jp.co.pockeps.rsssample.di.component;

import javax.inject.Singleton;

import dagger.Component;
import jp.co.pockeps.rsssample.activity.MainActivity;
import jp.co.pockeps.rsssample.di.module.AppModule;
import jp.co.pockeps.rsssample.di.module.RepositoryModule;

@Singleton
@Component(modules = {AppModule.class, RepositoryModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
}
