package jp.co.pockeps.rsssample.mock.di.component;

import javax.inject.Singleton;

import dagger.Component;
import jp.co.pockeps.rsssample.activity.MainActivity;
import jp.co.pockeps.rsssample.di.component.AppComponent;
import jp.co.pockeps.rsssample.di.module.AppModule;
import jp.co.pockeps.rsssample.mock.di.module.MockInfraLayerModule;

@Singleton
@Component(modules = {AppModule.class,MockInfraLayerModule.class})
public interface MockAppComponent extends AppComponent {
    void inject(MainActivity activity);
}
