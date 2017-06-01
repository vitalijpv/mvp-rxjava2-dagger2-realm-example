
package com.venuesapp.nearbyvenues.model.json;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class BeenHere {

    @SerializedName("lastCheckinExpiredAt")
    private Long mLastCheckinExpiredAt;

    public Long getLastCheckinExpiredAt() {
        return mLastCheckinExpiredAt;
    }

    public void setLastCheckinExpiredAt(Long lastCheckinExpiredAt) {
        mLastCheckinExpiredAt = lastCheckinExpiredAt;
    }

}
