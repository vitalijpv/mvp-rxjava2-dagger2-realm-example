
package com.venuesapp.nearbyvenues.model.json;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Response {

    @SerializedName("confident")
    private Boolean mConfident;
    @SerializedName("venues")
    private List<Venue> mVenues;

    public Boolean getConfident() {
        return mConfident;
    }

    public void setConfident(Boolean confident) {
        mConfident = confident;
    }

    public List<Venue> getVenues() {
        return mVenues;
    }

    public void setVenues(List<Venue> venues) {
        mVenues = venues;
    }

}
