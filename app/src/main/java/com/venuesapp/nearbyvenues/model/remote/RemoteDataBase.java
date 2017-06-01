package com.venuesapp.nearbyvenues.model.remote;

import com.venuesapp.nearbyvenues.MyApp;
import com.venuesapp.nearbyvenues.model.IApiFourSquare;
import com.venuesapp.nearbyvenues.model.IDataBase;
import com.venuesapp.nearbyvenues.model.LocationProvider;
import com.venuesapp.nearbyvenues.model.json.VenuesData;
import com.venuesapp.nearbyvenues.model.local.LocalDataBase;
import com.venuesapp.nearbyvenues.model.local.VenuesResponseRealm;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import io.realm.Realm;
import retrofit2.Retrofit;
import io.reactivex.Observable;


public class RemoteDataBase implements IDataBase {

    private String clientId;
    private String clientSecret;

    @Inject
    LocationProvider locationProvider;
    @Inject
    Retrofit retrofit;
    @Inject
    LocalDataBase localDataBase;

    public RemoteDataBase(String clientId, String clientSecret) {

        this.clientId = clientId;
        this.clientSecret = clientSecret;

        MyApp.getAppComponent().inject(this);

    }

    private String getCurDateStr() {
        Date curDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        return simpleDateFormat.format(curDate);
    }

    @Override
    public Observable<VenuesResponseRealm> getVenuesData() {

        return retrofit.create(IApiFourSquare.class).getVenuesData(locationProvider.getLocStr(), clientId, clientSecret, getCurDateStr()).
                flatMap(new Function<VenuesData, ObservableSource<VenuesResponseRealm>>() {
                    @Override
                    public ObservableSource<VenuesResponseRealm> apply(final VenuesData venuesData) throws Exception {
                        return Observable.create(
                                new ObservableOnSubscribe<VenuesResponseRealm>() {
                                    @Override
                                    public void subscribe(ObservableEmitter<VenuesResponseRealm> e) throws Exception {
                                        Realm realm = Realm.getDefaultInstance();
                                        VenuesResponseRealm venuesResponseRealmResult = localDataBase.writeToRealmDatabase(realm, venuesData, locationProvider.getLat(),locationProvider.getLon());
                                        if (venuesResponseRealmResult == null) {
                                            Observable.empty();
                                        } else
                                            e.onNext(realm.copyFromRealm(venuesResponseRealmResult));
                                        e.onComplete();
                                        realm.close();
                                    }
                                }
                        );
                    }
                });
    }
}
