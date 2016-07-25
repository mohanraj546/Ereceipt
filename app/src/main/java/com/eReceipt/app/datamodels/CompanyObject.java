package com.eReceipt.app.datamodels;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by developer on 18/7/16.
 */
public class CompanyObject implements Serializable {

    @SerializedName("companyName")
    private String company_name;

    public String getCompany_manufacturer() {
        return company_manufacturer;
    }

    public void setCompany_manufacturer(String company_manufacturer) {
        this.company_manufacturer = company_manufacturer;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getInvoice_count() {
        return invoice_count;
    }

    public void setInvoice_count(String invoice_count) {
        this.invoice_count = invoice_count;
    }

    @SerializedName("companyManufacturer")

    private String company_manufacturer;

    @SerializedName("invoiceCount")
    private String invoice_count;
}
