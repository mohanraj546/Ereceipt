package com.eReceipt.app.activities;

import android.os.Bundle;

import com.eReceipt.app.R;
import com.eReceipt.app.fragments.ContactDetailFragment;
import com.eReceipt.app.fragments.ContactListFragment;
import com.eReceipt.app.fragments.MyAccountFragment;

/**
 * Created by developer on 21/7/16.
 */
public class MyAccountActivity extends BaseNavigationActivity{

    MyAccountFragment myAccountFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar.setBackgroundColor(getResources().getColor(R.color.splash_background));
        setColorToStatusBar(getResources().getColor(R.color.splash_background));
        setGravityLeft();
        mTitle.setText(getResources().getString(R.string.nav_drawer_my_acct));
        myAccountFragment = MyAccountFragment.newInstance();
        loadFragment(myAccountFragment, R.id.container_body, "My Account");
    }
}
