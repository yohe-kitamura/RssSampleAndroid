package jp.co.pockeps.rsssample.mock.di.module;

import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;
import jp.co.pockeps.rsssample.repository.UxMilkRepository;

@Module
public class MockInfraLayerModule {

    private final UxMilkRepository repository;

    public MockInfraLayerModule(@NonNull UxMilkRepository repository) {
        this.repository = repository;
    }

    @Provides
    public UxMilkRepository provideUxMilkRepository(){
        return repository;
    }
}
