package com.eReceipt.app.datamodels;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by developer on 22/7/16.
 */
public class InvoiceDetail implements Serializable {

    @SerializedName("s.no")
    private String sno;

    @SerializedName("item name")
    private String item_name;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @SerializedName("qty")
    private String qty;

    @SerializedName("rate")
    private String rate;

    @SerializedName("amount")
    private String amount;
}
