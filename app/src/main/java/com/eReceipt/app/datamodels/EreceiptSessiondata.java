package com.eReceipt.app.datamodels;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.eReceipt.app.utils.EreceiptApplication;
import com.eReceipt.app.utils.SerializeDeserialize;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by developer on 18/7/16.
 */
public class EreceiptSessiondata {

    public static String ERECEIPT_APP = "EreceiptApp";
    private static EreceiptSessiondata sessionData;
    public static String SHPREF_KEY_COMPANY_OBJECT_LIST = "SHPREF_KEY_COMPANY_OBJECT_LIST";
    public static String SHPREF_KEY_CONTACT_OBJECT_LIST = "SHPREF_KEY_CONTACT_OBJECT_LIST";
    public static String SHPREF_KEY_PENDING_INVOICE_LIST = "SHPREF_KEY_PENDING_INVOICE_LIST";
    public static String SHPREF_KEY_COMPLETED_INVOICE_LIST = "SHPREF_KEY_COMPLETED_INVOICE_LIST";
    public static String SHPREF_KEY_ARCHIVE_INVOICE_LIST = "SHPREF_KEY_ARCHIVE_INVOICE_LIST";
    public static String SHPREF_KEY_STRING_FROM_WHICH_SCREEN = "SHPREF_KEY_STRING_FROM_WHICH_SCREEN";
    public static String SHPREF_KEY_INVOICE_DETAIL_ITEM = "SHPREF_KEY_INVOICE_DETAIL_ITEM";
    public static ArrayList<CompanyObject> companyObjectArrayList;
    public static ArrayList<ContactObject> contactObjectArrayList;
    public static ArrayList<InvoiceObject> invoiceObjectArrayList;
    public static ArrayList<InvoiceDetail> invoiceDetailArrayList;
    public static PaymentsReceived paymentsReceived;


    public static EreceiptSessiondata getSessionDataInstance() {
        if (sessionData == null) {
            sessionData = new EreceiptSessiondata();
        }
        return sessionData;
    }

    public void clearData() {
        EreceiptApplication.getAppContext().getSharedPreferences(ERECEIPT_APP, Context.MODE_PRIVATE).edit().clear().commit();
    }

    public static String getFromWhichScreen(){
        return EreceiptApplication.getAppContext().getSharedPreferences(ERECEIPT_APP,Context.MODE_PRIVATE).getString(SHPREF_KEY_STRING_FROM_WHICH_SCREEN, null);
    }

    public static void setFromWhichScreen(String fromWhichScreen){
        SharedPreferences.Editor prefsEditor = EreceiptApplication.getAppContext().getSharedPreferences(ERECEIPT_APP, Context.MODE_PRIVATE).edit();
        prefsEditor.putString(SHPREF_KEY_STRING_FROM_WHICH_SCREEN, fromWhichScreen);
        prefsEditor.commit();
    }

    public static void setCompanyObjectList() {
        try {
            InputStream inputStream = EreceiptApplication.getAppContext().getAssets().open("payments_received_test_data.json");
            JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream));
            Gson gson = new Gson();
            paymentsReceived = gson.fromJson(jsonReader,PaymentsReceived.class);
            SharedPreferences.Editor prefsEditor = EreceiptApplication.getAppContext().getSharedPreferences(ERECEIPT_APP, Context.MODE_PRIVATE).edit();
            prefsEditor.putString(SHPREF_KEY_COMPANY_OBJECT_LIST, SerializeDeserialize.serialize(paymentsReceived.getCompanyObjectList()));
            prefsEditor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<CompanyObject> getCompanyObjectList() {
        companyObjectArrayList = (ArrayList<CompanyObject>) SerializeDeserialize.deserialize(EreceiptApplication.getAppContext()
                .getSharedPreferences(ERECEIPT_APP, Context.MODE_PRIVATE)
                .getString(SHPREF_KEY_COMPANY_OBJECT_LIST, SerializeDeserialize.serialize(new ArrayList<CompanyObject>())));
        return companyObjectArrayList;
    }

    public static void setContactObjectList() {
        try {
            InputStream inputStream = EreceiptApplication.getAppContext().getAssets().open("payments_received_test_data.json");
            JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream));
            Gson gson = new Gson();
            paymentsReceived = gson.fromJson(jsonReader,PaymentsReceived.class);
            SharedPreferences.Editor prefsEditor = EreceiptApplication.getAppContext().getSharedPreferences(ERECEIPT_APP, Context.MODE_PRIVATE).edit();
            prefsEditor.putString(SHPREF_KEY_CONTACT_OBJECT_LIST, SerializeDeserialize.serialize(paymentsReceived.getContactObjectArrayList()));
            prefsEditor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<ContactObject> getContactObjectList() {
        contactObjectArrayList = (ArrayList<ContactObject>) SerializeDeserialize.deserialize(EreceiptApplication.getAppContext()
                .getSharedPreferences(ERECEIPT_APP, Context.MODE_PRIVATE)
                .getString(SHPREF_KEY_CONTACT_OBJECT_LIST, SerializeDeserialize.serialize(new ArrayList<ContactObject>())));
        return contactObjectArrayList;
    }

    public static void setPendingInvoiceList() {
        try {
            InputStream inputStream = EreceiptApplication.getAppContext().getAssets().open("payments_received_test_data.json");
            JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream));
            Gson gson = new Gson();
            paymentsReceived = gson.fromJson(jsonReader,PaymentsReceived.class);
            SharedPreferences.Editor prefsEditor = EreceiptApplication.getAppContext().getSharedPreferences(ERECEIPT_APP, Context.MODE_PRIVATE).edit();
            prefsEditor.putString(SHPREF_KEY_PENDING_INVOICE_LIST, SerializeDeserialize.serialize(paymentsReceived.getInvoiceObjectArrayList_pending()));
            prefsEditor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<InvoiceObject> getPendingInvoiceList() {
        invoiceObjectArrayList = (ArrayList<InvoiceObject>) SerializeDeserialize.deserialize(EreceiptApplication.getAppContext()
                .getSharedPreferences(ERECEIPT_APP, Context.MODE_PRIVATE)
                .getString(SHPREF_KEY_PENDING_INVOICE_LIST, SerializeDeserialize.serialize(new ArrayList<InvoiceObject>())));
        return invoiceObjectArrayList;
    }

    public static void setInvoiceDetail_Item() {
        try {
            InputStream inputStream = EreceiptApplication.getAppContext().getAssets().open("payments_received_test_data.json");
            JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream));
            Gson gson = new Gson();
            paymentsReceived = gson.fromJson(jsonReader,PaymentsReceived.class);
            SharedPreferences.Editor prefsEditor = EreceiptApplication.getAppContext().getSharedPreferences(ERECEIPT_APP, Context.MODE_PRIVATE).edit();
            prefsEditor.putString(SHPREF_KEY_INVOICE_DETAIL_ITEM, SerializeDeserialize.serialize(paymentsReceived.getInvoiceDetailArrayList()));
            prefsEditor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<InvoiceDetail> getInvoiceDetail_Item() {
        invoiceDetailArrayList = (ArrayList<InvoiceDetail>) SerializeDeserialize.deserialize(EreceiptApplication.getAppContext()
                .getSharedPreferences(ERECEIPT_APP, Context.MODE_PRIVATE)
                .getString(SHPREF_KEY_INVOICE_DETAIL_ITEM, SerializeDeserialize.serialize(new ArrayList<InvoiceDetail>())));
        return invoiceDetailArrayList;
    }
}
