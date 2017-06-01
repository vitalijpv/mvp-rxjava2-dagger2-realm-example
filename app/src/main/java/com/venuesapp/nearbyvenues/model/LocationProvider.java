package com.venuesapp.nearbyvenues.model;

import android.Manifest;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

import com.venuesapp.nearbyvenues.presenter.VenuesListPresenter;

public class LocationProvider {

    private LocationManager locationManager;
    private LocListener locListener;
    private Context context;
    private VenuesListPresenter venuesListPresenter;
    private Location currentLocation;
    private String provider;

    private long minTime;
    private float minDistance;


    public LocationProvider(Application app, long minTime, float minDistance) {

        this.minTime = minTime;
        this.minDistance = minDistance;

        this.context = app.getApplicationContext();

        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        if (locListener == null)
            locListener = new LocListener();

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_LOW);
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setSpeedRequired(false);
        criteria.setCostAllowed(true);
        provider = locationManager.getBestProvider(criteria, true);

        if (ActivityCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            locationManager.requestLocationUpdates(provider,
                    minTime, minDistance, locListener);
        }

        currentLocation = locationManager.getLastKnownLocation(provider);
        if (currentLocation == null)
            currentLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

    }

    public void removeUpdates() {
        locationManager.removeUpdates(locListener);
    }

    public void requestLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

            locationManager.requestLocationUpdates(provider,
                    minTime, minDistance, locListener);
        }
    }


    public Location getCurrentLocation() {
        return currentLocation;
    }

    public String getLocStr() {

        return String.valueOf(currentLocation.getLatitude() + "," + currentLocation.getLongitude());
    }

    public double getLat() {
        return currentLocation.getLatitude();
    }

    public double getLon() {
        return currentLocation.getLongitude();
    }

    public void setPresenter(VenuesListPresenter venuesListPresenter) {
        this.venuesListPresenter = venuesListPresenter;
    }

    private class LocListener implements LocationListener {

        // Важно, чтобы currentLocation был проинициализирован первым!
        // иначе при вызове loadVenuesDataFromRemoteDataBase() возникнет NPE, т.к. currentLocation = null
        @Override
        public void onLocationChanged(Location location) {
            currentLocation = location;
            venuesListPresenter.loadVenuesDataFromRemoteDataBase();

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }

        @Override
        public void onProviderEnabled(String provider) {
        }

        @Override
        public void onProviderDisabled(String provider) {
        }

    }


}
