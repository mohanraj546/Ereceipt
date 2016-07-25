package com.eReceipt.app.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eReceipt.app.R;
import com.eReceipt.app.activities.InvoiceListActivity;
import com.eReceipt.app.datamodels.CompanyObject;
import com.eReceipt.app.datamodels.EreceiptSessiondata;
import com.eReceipt.app.interfaces.CompanyDetailsListener;
import com.eReceipt.app.utils.AppConstants;

/**
 * Created by developer on 21/7/16.
 */
public class AddCompanyFragment extends Fragment implements View.OnClickListener {

    RelativeLayout relativeLayout_save;
    String str_From_Which_Screen="";

    public static AddCompanyFragment newInstance() {
        AddCompanyFragment fragment = new AddCompanyFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View add_comp_view = inflater.inflate(R.layout.fragment_add_company, container, false);
        initializeViews(add_comp_view);
        setDataToViews();
        return add_comp_view;
    }

    private void initializeViews(View add_comp_view) {
        relativeLayout_save =(RelativeLayout)add_comp_view.findViewById(R.id.rel_save);

        str_From_Which_Screen = EreceiptSessiondata.getFromWhichScreen();

        if(str_From_Which_Screen!= null){
            if(str_From_Which_Screen.equals(AppConstants.MY_CUSTOMERS_SCREEN) || str_From_Which_Screen.equals(AppConstants.PAYMENTS_RECEIVED_SCREEN))
            {
                relativeLayout_save.setBackgroundColor(getResources().getColor(R.color.pay_rcv_tool_bar_bg));
            }else{
                relativeLayout_save.setBackgroundColor(getResources().getColor(R.color.pay_gvn_tool_bar_bg));
            }
        }
    }

    private void setDataToViews() {
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }
}
