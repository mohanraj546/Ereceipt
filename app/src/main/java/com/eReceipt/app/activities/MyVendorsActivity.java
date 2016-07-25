package com.eReceipt.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.eReceipt.app.R;
import com.eReceipt.app.fragments.ContactDetailFragment;
import com.eReceipt.app.fragments.ContactListFragment;
import com.eReceipt.app.interfaces.CompanyDetailsListener;
import com.eReceipt.app.interfaces.ContactDetailListener;

/**
 * Created by developer on 20/7/16.
 */
public class MyVendorsActivity extends BaseNavigationActivity implements ContactDetailListener{

    ContactListFragment contactListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar.setBackgroundColor(getResources().getColor(R.color.pay_gvn_tool_bar_bg));
        setGravityLeft();
        setColorToStatusBar(getResources().getColor(R.color.pay_gvn_tool_bar_bg));
        mTitle.setText(getResources().getString(R.string.nav_drawer_vendors));
        contactListFragment = ContactListFragment.newInstance();
        loadFragment(contactListFragment, R.id.container_body, "Contact List");
    }

    @Override
    public void loadContactDetail() {
        Intent loadContactDetail = new Intent(this,ContactDetailActivity.class);
        startActivity(loadContactDetail);
    }
}
