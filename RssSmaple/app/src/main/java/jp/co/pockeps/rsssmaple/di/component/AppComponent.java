package jp.co.pockeps.rsssmaple.di.component;

import javax.inject.Singleton;

import dagger.Component;
import jp.co.pockeps.rsssmaple.activity.MainActivity;
import jp.co.pockeps.rsssmaple.di.module.AppModule;
import jp.co.pockeps.rsssmaple.di.module.InfraLayerModule;

@Singleton
@Component(modules = {AppModule.class, InfraLayerModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
}
