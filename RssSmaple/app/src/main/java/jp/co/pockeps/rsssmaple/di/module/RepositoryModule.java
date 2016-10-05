package jp.co.pockeps.rsssmaple.di.module;

import dagger.Module;
import dagger.Provides;
import jp.co.pockeps.rsssmaple.repository.UxMilkRepository;

@Module
public class RepositoryModule {

    @Provides
    UxMilkRepository provideUxMilkRepository() {
        return new UxMilkRepository();
    }
}
