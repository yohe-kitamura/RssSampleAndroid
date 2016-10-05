package jp.co.pockeps.rsssmaple;

import android.app.Application;

import jp.co.pockeps.rsssmaple.di.component.AppComponent;
import jp.co.pockeps.rsssmaple.di.component.DaggerAppComponent;
import jp.co.pockeps.rsssmaple.di.module.AppModule;

public class MyApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector(){
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this)).build();
    }

    public AppComponent getApplicationComponent(){
        return appComponent;
    }

    public void setAppComponent(AppComponent appComponent) {
        this.appComponent = appComponent;
    }
}
