
package com.venuesapp.nearbyvenues.model.json;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Contact {

    @SerializedName("formattedPhone")
    private String mFormattedPhone;
    @SerializedName("phone")
    private String mPhone;
    @SerializedName("twitter")
    private String mTwitter;

    public String getFormattedPhone() {
        return mFormattedPhone;
    }

    public void setFormattedPhone(String formattedPhone) {
        mFormattedPhone = formattedPhone;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getTwitter() {
        return mTwitter;
    }

    public void setTwitter(String twitter) {
        mTwitter = twitter;
    }

}
