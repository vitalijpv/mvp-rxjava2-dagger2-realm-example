package com.venuesapp.nearbyvenues.model;

import com.venuesapp.nearbyvenues.model.local.LocalDataBase;
import com.venuesapp.nearbyvenues.model.local.VenuesResponseRealm;
import com.venuesapp.nearbyvenues.model.remote.RemoteDataBase;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Predicate;

public class Repository implements IDataBase {

    private LocalDataBase localDataBase;
    private RemoteDataBase remoteDataBase;
    private LocationProvider locationProvider;

    @Inject
    public Repository(LocalDataBase localDataBase, RemoteDataBase remoteDataBase, LocationProvider locationProvider) {
        this.localDataBase = localDataBase;
        this.remoteDataBase = remoteDataBase;
        this.locationProvider = locationProvider;

    }

    @Override
    public Observable<VenuesResponseRealm> getVenuesData() {

        return Observable.concat(localDataBase.getVenuesData(), remoteDataBase.getVenuesData()).
                filter(new Predicate<VenuesResponseRealm>() {
                    @Override
                    public boolean test(VenuesResponseRealm venuesResponseRealm) throws Exception {
                        return isUpToDate(venuesResponseRealm);
                    }
                }).take(1);
    }

    // определяем актуальность данных
    private boolean isUpToDate(VenuesResponseRealm venuesResponseRealm) {

        Date realmDate = venuesResponseRealm.getDate();
        if (realmDate == null) return false;

        double realmLon = venuesResponseRealm.getLongitude();
        double realmLat = venuesResponseRealm.getLatitude();

        double curLat = locationProvider.getLat();
        double curLon = locationProvider.getLon();

        if (calculateDistanceInKm(curLat, curLon, realmLat, realmLon) < 1) {

            Date curDate = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            String realmDateStr = simpleDateFormat.format(realmDate);
            String curDateStr = simpleDateFormat.format(curDate);

            try {
                Date realmDateResult = simpleDateFormat.parse(realmDateStr);
                Date curDateResult = simpleDateFormat.parse(curDateStr);
                return curDateResult.compareTo(realmDateResult) == 0;
            } catch (Exception e) {
                return false;
            }
        }

        return false;
    }

    // расстояние между двумя точками широты и долготы соответственно
    // необходимо, чтобы определить: пользователь сменил местоположение с последнего запуска приложения или нет
    private int calculateDistanceInKm(double userLat, double userLng, double venueLat, double venueLng) {
        double AVERAGE_RADIUS_OF_EARTH = 6371;
        double latDistance = Math.toRadians(userLat - venueLat);
        double lngDistance = Math.toRadians(userLng - venueLng);

        double a = (Math.sin(latDistance / 2) * Math.sin(latDistance / 2)) +
                (Math.cos(Math.toRadians(userLat))) *
                        (Math.cos(Math.toRadians(venueLat))) *
                        (Math.sin(lngDistance / 2)) *
                        (Math.sin(lngDistance / 2));

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return (int) (Math.round(AVERAGE_RADIUS_OF_EARTH * c));

    }
}
