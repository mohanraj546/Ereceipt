package com.eReceipt.app.datamodels;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by developer on 19/7/16.
 */
public class ContactObject implements Serializable {

    @SerializedName("contactName")
    private String contactName;

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @SerializedName("contactNumber")
    private String contactNumber;
}
