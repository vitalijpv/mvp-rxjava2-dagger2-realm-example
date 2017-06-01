package com.venuesapp.nearbyvenues.presenter;

import com.venuesapp.nearbyvenues.MyApp;
import com.venuesapp.nearbyvenues.model.LocationProvider;
import com.venuesapp.nearbyvenues.model.Repository;
import com.venuesapp.nearbyvenues.model.local.VenuesResponseRealm;
import com.venuesapp.nearbyvenues.model.remote.RemoteDataBase;
import com.venuesapp.nearbyvenues.view.VenuesListActivity;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class VenuesListPresenter implements VenuesListContract.Actions {

    private static final String MESSAGE_GET_VENUES_DATA_COMPLETE = "MESSAGE_GET_VENUES_DATA_COMPLETE";
    private static final String MESSAGE_GET_VENUES_DATA_ERROR = "MESSAGE_GET_VENUES_DATA_ERROR";
    private static final String MESSAGE_UPDATE_VENUES_DATA_COMPLETE = "MESSAGE_UPDATE_VENUES_DATA_COMPLETE";
    private static final String MESSAGE_UPDATE_VENUES_DATA_ERROR = "MESSAGE_UPDATE_VENUES_DATA_ERROR";
    private static final String MESSAGE_GET_LOCATION_DATA_ERROR = "MESSAGE_GET_LOCATION_DATA_ERROR";


    private VenuesListContract.View view;
    private Disposable disposable;

    @Inject
    Repository repository;
    @Inject
    RemoteDataBase remoteDataBase;
    @Inject
    LocationProvider locationProvider;


    public VenuesListPresenter(VenuesListActivity venuesListActivity) {
        this.view = venuesListActivity;
        MyApp.getAppComponent().inject(this);

        locationProvider.setPresenter(this);
    }

    @Override
    public void loadVenuesData() {
        disposable = repository.getVenuesData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<VenuesResponseRealm>() {
                    @Override
                    public void onError(Throwable e) {
                        view.showError(MESSAGE_GET_VENUES_DATA_ERROR);
                    }

                    @Override
                    public void onComplete() {
                        view.showComplete(MESSAGE_GET_VENUES_DATA_COMPLETE);
                    }

                    @Override
                    public void onNext(VenuesResponseRealm venuesResponseRealm) {
                        view.showVenues(venuesResponseRealm);
                    }
                });
    }

    @Override
    public void loadVenuesDataFromRemoteDataBase() {
        disposable = remoteDataBase.getVenuesData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<VenuesResponseRealm>() {
                    @Override
                    public void onError(Throwable e) {
                        view.showError(MESSAGE_UPDATE_VENUES_DATA_ERROR);
                    }

                    @Override
                    public void onComplete() {
                        view.showComplete(MESSAGE_UPDATE_VENUES_DATA_COMPLETE);
                    }

                    @Override
                    public void onNext(VenuesResponseRealm venuesResponseRealm) {
                        view.showVenues(venuesResponseRealm);
                    }
                });
    }

    @Override
    public void subscribe() {
        if (locationProvider.getCurrentLocation() != null) {
            loadVenuesData();
            locationProvider.requestLocationUpdates();
        } else view.showError(MESSAGE_GET_LOCATION_DATA_ERROR);
    }

    @Override
    public void unsubscribe() {
        if (disposable != null && disposable.isDisposed())
            disposable.dispose();

        if (locationProvider.getCurrentLocation() != null) locationProvider.removeUpdates();
    }


}
