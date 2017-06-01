
package com.venuesapp.nearbyvenues.model.json;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Group {

    @SerializedName("count")
    private Long mCount;
    @SerializedName("items")
    private List<Object> mItems;
    @SerializedName("name")
    private String mName;
    @SerializedName("type")
    private String mType;

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

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

}
