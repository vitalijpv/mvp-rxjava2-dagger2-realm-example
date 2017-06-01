package com.venuesapp.nearbyvenues;

import android.app.Application;

import com.venuesapp.nearbyvenues.dagger.component.DaggerIAppComponent;
import com.venuesapp.nearbyvenues.dagger.component.IAppComponent;
import com.venuesapp.nearbyvenues.dagger.module.AppModule;
import com.venuesapp.nearbyvenues.dagger.module.DataModule;

import io.realm.Realm;

public class MyApp extends Application {

    // адрес api сервера
    public static final String BASE_URL = "https://api.foursquare.com/v2/venues/";

    // время автообновления данных с LocationProvider ( мс. )
    // = 1 минута
    public static final long MINTIME = 60000;

    // автообновление данных LocationProvide, когда устройство переместиться на указанное расстояние ( м. )
    // = 1 км.
    public static final float MINDISTANCE = 1000;
    // идентификатор клиента foursquare
    public static final String CLIENT_ID = "";
    // secret key клиента foursquare
    public static final String CLIENT_SECRET = "";

    private static IAppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);

        appComponent = DaggerIAppComponent.builder()
                .appModule(new AppModule(this))
                .dataModule(new DataModule(BASE_URL, MINTIME, MINDISTANCE, CLIENT_ID, CLIENT_SECRET))
                .build();
    }

    public static IAppComponent getAppComponent() {
        return appComponent;
    }


}
