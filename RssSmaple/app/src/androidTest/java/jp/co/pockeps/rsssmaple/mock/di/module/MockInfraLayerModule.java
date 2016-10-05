package jp.co.pockeps.rsssmaple.mock.di.module;

import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;
import jp.co.pockeps.rsssmaple.repository.UxMilkRepository;

@Module
public class MockInfraLayerModule {

    final UxMilkRepository repository;

    public MockInfraLayerModule(@NonNull UxMilkRepository repository) {
        this.repository = repository;
    }

    @Provides
    public UxMilkRepository provideUxMilkRepository(){
        return repository;
    }
}
