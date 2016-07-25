package com.eReceipt.app.datamodels;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by developer on 18/7/16.
 */
public class PaymentsReceived implements Serializable {

    @SerializedName("payments_received")
    ArrayList<CompanyObject> companyObjectList;

    @SerializedName("contacts_list")
    ArrayList<ContactObject> contactObjectArrayList;

    @SerializedName("pending_invoices_list")
    ArrayList<InvoiceObject> invoiceObjectArrayList_pending;

    public ArrayList<InvoiceDetail> getInvoiceDetailArrayList() {
        return invoiceDetailArrayList;
    }

    public void setInvoiceDetailArrayList(ArrayList<InvoiceDetail> invoiceDetailArrayList) {
        this.invoiceDetailArrayList = invoiceDetailArrayList;
    }

    @SerializedName("completed_invoices_list")

    ArrayList<InvoiceObject> invoiceObjectArrayList_completed;

    @SerializedName("items_list")
    ArrayList<InvoiceDetail> invoiceDetailArrayList;

    public ArrayList<InvoiceObject> getInvoiceObjectArrayList_pending() {
        return invoiceObjectArrayList_pending;
    }

    public void setInvoiceObjectArrayList_pending(ArrayList<InvoiceObject> invoiceObjectArrayList_pending) {
        this.invoiceObjectArrayList_pending = invoiceObjectArrayList_pending;
    }

    public ArrayList<InvoiceObject> getInvoiceObjectArrayList_completed() {
        return invoiceObjectArrayList_completed;
    }

    public void setInvoiceObjectArrayList_completed(ArrayList<InvoiceObject> invoiceObjectArrayList_completed) {
        this.invoiceObjectArrayList_completed = invoiceObjectArrayList_completed;
    }

    public ArrayList<InvoiceObject> getInvoiceObjectArrayList_archive() {
        return invoiceObjectArrayList_archive;
    }

    public void setInvoiceObjectArrayList_archive(ArrayList<InvoiceObject> invoiceObjectArrayList_archive) {
        this.invoiceObjectArrayList_archive = invoiceObjectArrayList_archive;
    }

    @SerializedName("archive_invoices_list")
    ArrayList<InvoiceObject> invoiceObjectArrayList_archive;

    public ArrayList<ContactObject> getContactObjectArrayList() {
        return contactObjectArrayList;
    }

    public void setContactObjectArrayList(ArrayList<ContactObject> contactObjectArrayList) {
        this.contactObjectArrayList = contactObjectArrayList;
    }

    public ArrayList<CompanyObject> getCompanyObjectList() {
        return companyObjectList;
    }

    public void setCompanyObjectList(ArrayList<CompanyObject> companyObjectList) {
        this.companyObjectList = companyObjectList;
    }
}
