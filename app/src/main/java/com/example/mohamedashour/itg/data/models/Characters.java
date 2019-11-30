
package com.example.mohamedashour.itg.data.models;


import com.google.gson.annotations.SerializedName;

public class Characters {

    @SerializedName("code")
    private Long mCode;
    @SerializedName("data")
    private Data mData;
    @SerializedName("status")
    private String mStatus;

    public Long getCode() {
        return mCode;
    }

    public void setCode(Long code) {
        mCode = code;
    }

    public Data getData() {
        return mData;
    }

    public void setData(Data data) {
        mData = data;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

}
