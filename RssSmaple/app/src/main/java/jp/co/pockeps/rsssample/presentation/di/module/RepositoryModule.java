package jp.co.pockeps.rsssample.presentation.di.module;

import dagger.Module;
import dagger.Provides;
import jp.co.pockeps.rsssample.repository.UxMilkRepository;

@Module
public class RepositoryModule {

    @Provides
    UxMilkRepository provideUxMilkRepository() {
        return new UxMilkRepository();
    }
}
