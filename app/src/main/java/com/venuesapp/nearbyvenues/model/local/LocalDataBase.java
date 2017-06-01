package com.venuesapp.nearbyvenues.model.local;

import com.venuesapp.nearbyvenues.model.IDataBase;
import com.venuesapp.nearbyvenues.model.json.Venue;
import com.venuesapp.nearbyvenues.model.json.VenuesData;

import java.util.Date;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.realm.Realm;
import io.realm.RealmList;

public class LocalDataBase implements IDataBase {

    public VenuesResponseRealm writeToRealmDatabase(Realm realm, VenuesData venuesData, double curLat, double curLon) {
        VenuesResponseRealm venuesResponseRealm = new VenuesResponseRealm();

        Date date = new Date();
        venuesResponseRealm.setId(1);
        venuesResponseRealm.setDate(date);
        venuesResponseRealm.setLatitude(curLat);
        venuesResponseRealm.setLongitude(curLon);

        RealmList<VenueRealm> venueRealmList = new RealmList<>();

        for (Venue venue : venuesData.getResponse().getVenues()) {
            VenueRealm venueRealm = new VenueRealm();

            venueRealm.setId(venue.getId());
            venueRealm.setName(venue.getName());
            venueRealm.setAddress(venue.getLocation().getAddress());
            venueRealm.setFormattedPhone(venue.getContact().getFormattedPhone());
            venueRealmList.add(venueRealm);
        }

        venuesResponseRealm.setVenues(venueRealmList);

        realm.beginTransaction();
        VenuesResponseRealm venuesResponseRealmNew = realm.copyToRealmOrUpdate(venuesResponseRealm);
        realm.commitTransaction();
        return venuesResponseRealmNew;

    }


    @Override
    public Observable<VenuesResponseRealm> getVenuesData() {

        return Observable.create(
                new ObservableOnSubscribe<VenuesResponseRealm>() {
                    @Override
                    public void subscribe(ObservableEmitter<VenuesResponseRealm> e) throws Exception {
                        Realm realm = Realm.getDefaultInstance();
                        VenuesResponseRealm venuesResponseRealm = realm.where(VenuesResponseRealm.class).findFirst();
                        if (venuesResponseRealm == null) {
                            Observable.empty();
                        } else e.onNext(realm.copyFromRealm(venuesResponseRealm));
                        e.onComplete();
                        realm.close();
                    }
                }
        );

    }
}
