
package com.venuesapp.nearbyvenues.model.json;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Location {

    @SerializedName("address")
    private String mAddress;
    @SerializedName("cc")
    private String mCc;
    @SerializedName("city")
    private String mCity;
    @SerializedName("country")
    private String mCountry;
    @SerializedName("crossStreet")
    private String mCrossStreet;
    @SerializedName("distance")
    private Long mDistance;
    @SerializedName("formattedAddress")
    private List<String> mFormattedAddress;
    @SerializedName("labeledLatLngs")
    private List<LabeledLatLng> mLabeledLatLngs;
    @SerializedName("lat")
    private Double mLat;
    @SerializedName("lng")
    private Double mLng;
    @SerializedName("postalCode")
    private String mPostalCode;
    @SerializedName("state")
    private String mState;

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getCc() {
        return mCc;
    }

    public void setCc(String cc) {
        mCc = cc;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(String city) {
        mCity = city;
    }

    public String getCountry() {
        return mCountry;
    }

    public void setCountry(String country) {
        mCountry = country;
    }

    public String getCrossStreet() {
        return mCrossStreet;
    }

    public void setCrossStreet(String crossStreet) {
        mCrossStreet = crossStreet;
    }

    public Long getDistance() {
        return mDistance;
    }

    public void setDistance(Long distance) {
        mDistance = distance;
    }

    public List<String> getFormattedAddress() {
        return mFormattedAddress;
    }

    public void setFormattedAddress(List<String> formattedAddress) {
        mFormattedAddress = formattedAddress;
    }

    public List<LabeledLatLng> getLabeledLatLngs() {
        return mLabeledLatLngs;
    }

    public void setLabeledLatLngs(List<LabeledLatLng> labeledLatLngs) {
        mLabeledLatLngs = labeledLatLngs;
    }

    public Double getLat() {
        return mLat;
    }

    public void setLat(Double lat) {
        mLat = lat;
    }

    public Double getLng() {
        return mLng;
    }

    public void setLng(Double lng) {
        mLng = lng;
    }

    public String getPostalCode() {
        return mPostalCode;
    }

    public void setPostalCode(String postalCode) {
        mPostalCode = postalCode;
    }

    public String getState() {
        return mState;
    }

    public void setState(String state) {
        mState = state;
    }

}
