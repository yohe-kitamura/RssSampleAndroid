package jp.co.pockeps.rsssample;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import jp.co.pockeps.rsssample.di.component.AppComponent;
import jp.co.pockeps.rsssample.di.component.DaggerAppComponent;
import jp.co.pockeps.rsssample.di.module.AppModule;

public class MyApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
        LeakCanary.install(this);
    }

    private void initializeInjector() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this)).build();
    }

    public AppComponent getApplicationComponent() {
        return appComponent;
    }

    public void setAppComponent(AppComponent appComponent) {
        this.appComponent = appComponent;
    }
}
