package com.eReceipt.app.activities;

import android.os.Bundle;

import com.eReceipt.app.R;
import com.eReceipt.app.fragments.CustomerEntryFormFragment;

/**
 * Created by developer on 20/7/16.
 */
public class CustomerEntryFormActivity extends BaseNavigationActivity{

    CustomerEntryFormFragment customerEntryFormFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar.setBackgroundColor(getResources().getColor(R.color.pay_rcv_tool_bar_bg));
        mTitle.setText(getResources().getString(R.string.cus_entry_form_title));
        setGravityLeft();
        customerEntryFormFragment = CustomerEntryFormFragment.newInstance();
        loadFragment(customerEntryFormFragment, R.id.container_body, "Customer Entry Form");
        setColorToStatusBar(getResources().getColor(R.color.pay_rcv_tool_bar_bg));
    }
}
