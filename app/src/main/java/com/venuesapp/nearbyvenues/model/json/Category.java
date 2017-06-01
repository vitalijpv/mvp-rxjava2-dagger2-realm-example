
package com.venuesapp.nearbyvenues.model.json;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Category {

    @SerializedName("icon")
    private Icon mIcon;
    @SerializedName("id")
    private String mId;
    @SerializedName("name")
    private String mName;
    @SerializedName("pluralName")
    private String mPluralName;
    @SerializedName("primary")
    private Boolean mPrimary;
    @SerializedName("shortName")
    private String mShortName;

    public Icon getIcon() {
        return mIcon;
    }

    public void setIcon(Icon icon) {
        mIcon = icon;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPluralName() {
        return mPluralName;
    }

    public void setPluralName(String pluralName) {
        mPluralName = pluralName;
    }

    public Boolean getPrimary() {
        return mPrimary;
    }

    public void setPrimary(Boolean primary) {
        mPrimary = primary;
    }

    public String getShortName() {
        return mShortName;
    }

    public void setShortName(String shortName) {
        mShortName = shortName;
    }

}
