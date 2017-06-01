
package com.venuesapp.nearbyvenues.model.json;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Venue {

    @SerializedName("allowMenuUrlEdit")
    private Boolean mAllowMenuUrlEdit;
    @SerializedName("beenHere")
    private BeenHere mBeenHere;
    @SerializedName("categories")
    private List<Category> mCategories;
    @SerializedName("contact")
    private Contact mContact;
    @SerializedName("hasPerk")
    private Boolean mHasPerk;
    @SerializedName("hereNow")
    private HereNow mHereNow;
    @SerializedName("id")
    private String mId;
    @SerializedName("location")
    private Location mLocation;
    @SerializedName("name")
    private String mName;
    @SerializedName("referralId")
    private String mReferralId;
    @SerializedName("specials")
    private Specials mSpecials;
    @SerializedName("stats")
    private Stats mStats;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("venueChains")
    private List<VenueChain> mVenueChains;
    @SerializedName("venueRatingBlacklisted")
    private Boolean mVenueRatingBlacklisted;
    @SerializedName("verified")
    private Boolean mVerified;

    public Boolean getAllowMenuUrlEdit() {
        return mAllowMenuUrlEdit;
    }

    public void setAllowMenuUrlEdit(Boolean allowMenuUrlEdit) {
        mAllowMenuUrlEdit = allowMenuUrlEdit;
    }

    public BeenHere getBeenHere() {
        return mBeenHere;
    }

    public void setBeenHere(BeenHere beenHere) {
        mBeenHere = beenHere;
    }

    public List<Category> getCategories() {
        return mCategories;
    }

    public void setCategories(List<Category> categories) {
        mCategories = categories;
    }

    public Contact getContact() {
        return mContact;
    }

    public void setContact(Contact contact) {
        mContact = contact;
    }

    public Boolean getHasPerk() {
        return mHasPerk;
    }

    public void setHasPerk(Boolean hasPerk) {
        mHasPerk = hasPerk;
    }

    public HereNow getHereNow() {
        return mHereNow;
    }

    public void setHereNow(HereNow hereNow) {
        mHereNow = hereNow;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public Location getLocation() {
        return mLocation;
    }

    public void setLocation(Location location) {
        mLocation = location;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getReferralId() {
        return mReferralId;
    }

    public void setReferralId(String referralId) {
        mReferralId = referralId;
    }

    public Specials getSpecials() {
        return mSpecials;
    }

    public void setSpecials(Specials specials) {
        mSpecials = specials;
    }

    public Stats getStats() {
        return mStats;
    }

    public void setStats(Stats stats) {
        mStats = stats;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public List<VenueChain> getVenueChains() {
        return mVenueChains;
    }

    public void setVenueChains(List<VenueChain> venueChains) {
        mVenueChains = venueChains;
    }

    public Boolean getVenueRatingBlacklisted() {
        return mVenueRatingBlacklisted;
    }

    public void setVenueRatingBlacklisted(Boolean venueRatingBlacklisted) {
        mVenueRatingBlacklisted = venueRatingBlacklisted;
    }

    public Boolean getVerified() {
        return mVerified;
    }

    public void setVerified(Boolean verified) {
        mVerified = verified;
    }

}
