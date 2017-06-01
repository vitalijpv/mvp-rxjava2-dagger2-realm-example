package com.venuesapp.nearbyvenues.model;

import com.venuesapp.nearbyvenues.model.local.VenuesResponseRealm;

import io.reactivex.Observable;


public interface IDataBase {
    Observable<VenuesResponseRealm> getVenuesData();
}
