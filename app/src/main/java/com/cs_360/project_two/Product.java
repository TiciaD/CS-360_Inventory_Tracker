package com.cs_360.project_two;

public class Product {
    public Product(long mId, String mName, String mDescription, long mQuantity) {
        this.mId = mId;
        this.mName = mName;
        this.mDescription = mDescription;
        this.mQuantity = mQuantity;
    }

    private long mId;
    private String mName;
    private String mDescription;
    private long mQuantity;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public long getmQuantity() {
        return mQuantity;
    }

    public void setmQuantity(long mQuantity) {
        this.mQuantity = mQuantity;
    }

    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }
}
