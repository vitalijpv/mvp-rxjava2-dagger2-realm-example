package com.venuesapp.nearbyvenues.dagger.module;

import android.app.Application;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.venuesapp.nearbyvenues.BuildConfig;
import com.venuesapp.nearbyvenues.model.LocationProvider;
import com.venuesapp.nearbyvenues.model.local.LocalDataBase;
import com.venuesapp.nearbyvenues.model.remote.RemoteDataBase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DataModule {

    private String baseUrl;
    private long mintime;
    private float mindistance;
    private String clientId;
    private String clientSecret;

    public DataModule(String baseUrl, long mintime, float mindistance, String clientId, String clientSecret) {
        this.baseUrl = baseUrl;
        this.mintime = mintime;
        this.mindistance = mindistance;
        this.clientId = clientId;
        this.clientSecret = clientSecret;

    }

    @Provides
    @Singleton
    OkHttpClient provideOkhttpClient() {
        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel((BuildConfig.DEBUG) ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE));
        return client.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    LocalDataBase porvideLocalDataBase() {
        return new LocalDataBase();
    }

    @Provides
    @Singleton
    RemoteDataBase provideRemoteDataBase() {
        return new RemoteDataBase(clientId, clientSecret);
    }

    @Provides
    @Singleton
    LocationProvider provideLocationProvider(Application app) {
        return new LocationProvider(app, mintime, mindistance);
    }


}
