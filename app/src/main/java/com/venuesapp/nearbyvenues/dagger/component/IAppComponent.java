package com.venuesapp.nearbyvenues.dagger.component;

import com.venuesapp.nearbyvenues.dagger.module.AppModule;
import com.venuesapp.nearbyvenues.dagger.module.DataModule;
import com.venuesapp.nearbyvenues.model.remote.RemoteDataBase;
import com.venuesapp.nearbyvenues.presenter.VenuesListPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Pointz on 13.05.2017.
 */
@Singleton
@Component(modules = {AppModule.class, DataModule.class})
public interface IAppComponent {

    void inject(RemoteDataBase remoteDataBase);

    void inject(VenuesListPresenter venuesListPresenter);

}
