package com.venuesapp.nearbyvenues.model.local;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class VenueRealm extends RealmObject {

    @PrimaryKey
    private String id;
    private String name;
    private String formattedPhone;
    private String address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFormattedPhone() {
        return formattedPhone;
    }

    public void setFormattedPhone(String formattedPhone) {
        this.formattedPhone = formattedPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
