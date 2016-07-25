package com.eReceipt.app.activities;

import android.os.Bundle;

import com.eReceipt.app.R;
import com.eReceipt.app.fragments.CustomerEntryFormFragment;
import com.eReceipt.app.fragments.VendorEntryFormFragment;

/**
 * Created by developer on 21/7/16.
 */
public class VendorEntryFormActivity extends BaseNavigationActivity {

    VendorEntryFormFragment vendorEntryFormFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar.setBackgroundColor(getResources().getColor(R.color.pay_gvn_tool_bar_bg));
        mTitle.setText(getResources().getString(R.string.ven_entry_form_title));
        setGravityLeft();
        vendorEntryFormFragment = VendorEntryFormFragment.newInstance();
        loadFragment(vendorEntryFormFragment, R.id.container_body, "Vendor Entry Form");
        setColorToStatusBar(getResources().getColor(R.color.pay_gvn_tool_bar_bg));
    }
}
