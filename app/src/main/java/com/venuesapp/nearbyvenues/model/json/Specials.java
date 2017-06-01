
package com.venuesapp.nearbyvenues.model.json;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Specials {

    @SerializedName("count")
    private Long mCount;
    @SerializedName("items")
    private List<Object> mItems;

    public Long getCount() {
        return mCount;
    }

    public void setCount(Long count) {
        mCount = count;
    }

    public List<Object> getItems() {
        return mItems;
    }

    public void setItems(List<Object> items) {
        mItems = items;
    }

}
