package com.venuesapp.nearbyvenues.model.local;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class VenuesResponseRealm extends RealmObject {

    // храниит всегда 1, т.к. данный объект нужен в единственном экземпляре
    @PrimaryKey
    private long id;

    /*
    * поля latitude, longitude, date используюся для определения устаревших данных в local database
    * чтобы при получении этих новых значений понимать, лежат ли старые данные в local database или нет.
    * и при необходимости их обновлять из remote database
    * устаревшими данными считаем, когда пользователь сменил свое место пребывания или
    * запустил приложение уже спустя 1 день
     */

    // хранит значение широты, в каком месте запись была сделана (получены данные с remote api)
    private Double latitude;
    // хранит значение долготы, в каком месте запись была сделана (получены данные с remote api)
    private Double longitude;
    // хранит дату, когда запись была сделана, в какой день были получены данные с remote api
    private Date date;
    // список venues
    private RealmList<VenueRealm> venues;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public RealmList<VenueRealm> getVenues() {
        return venues;
    }

    public void setVenues(RealmList<VenueRealm> venues) {
        this.venues = venues;
    }
}
