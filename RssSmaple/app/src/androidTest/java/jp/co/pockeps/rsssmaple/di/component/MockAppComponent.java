package jp.co.pockeps.rsssmaple.di.component;

import javax.inject.Singleton;

import dagger.Component;
import jp.co.pockeps.rsssmaple.activity.MainActivity;
import jp.co.pockeps.rsssmaple.di.module.AppModule;
import jp.co.pockeps.rsssmaple.di.module.MockInfraLayerModule;

@Singleton
@Component(modules = {AppModule.class,MockInfraLayerModule.class})
public interface MockAppComponent extends AppComponent{
    void inject(MainActivity activity);
}
