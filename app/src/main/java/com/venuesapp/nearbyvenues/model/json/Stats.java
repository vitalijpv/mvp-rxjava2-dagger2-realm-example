
package com.venuesapp.nearbyvenues.model.json;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Stats {

    @SerializedName("checkinsCount")
    private Long mCheckinsCount;
    @SerializedName("tipCount")
    private Long mTipCount;
    @SerializedName("usersCount")
    private Long mUsersCount;

    public Long getCheckinsCount() {
        return mCheckinsCount;
    }

    public void setCheckinsCount(Long checkinsCount) {
        mCheckinsCount = checkinsCount;
    }

    public Long getTipCount() {
        return mTipCount;
    }

    public void setTipCount(Long tipCount) {
        mTipCount = tipCount;
    }

    public Long getUsersCount() {
        return mUsersCount;
    }

    public void setUsersCount(Long usersCount) {
        mUsersCount = usersCount;
    }

}
