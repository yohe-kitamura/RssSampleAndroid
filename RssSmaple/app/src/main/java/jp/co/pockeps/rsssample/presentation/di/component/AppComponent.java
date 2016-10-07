package jp.co.pockeps.rsssample.presentation.di.component;

import javax.inject.Singleton;

import dagger.Component;
import jp.co.pockeps.rsssample.presentation.activity.MainActivity;
import jp.co.pockeps.rsssample.presentation.di.module.AppModule;
import jp.co.pockeps.rsssample.presentation.di.module.RepositoryModule;

@Singleton
@Component(modules = {AppModule.class, RepositoryModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
}
