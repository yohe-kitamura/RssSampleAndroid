package jp.co.pockeps.rsssmaple.di.component;

import javax.inject.Singleton;

import dagger.Component;
import jp.co.pockeps.rsssmaple.activity.MainActivity;
import jp.co.pockeps.rsssmaple.di.module.AppModule;
import jp.co.pockeps.rsssmaple.di.module.RepositoryModule;

@Singleton
@Component(modules = {AppModule.class, RepositoryModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
}
