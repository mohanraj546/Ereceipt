package com.eReceipt.app.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.eReceipt.app.R;
import com.eReceipt.app.datamodels.EnvironmentSettings;
import com.eReceipt.app.datamodels.EreceiptSessiondata;
import com.eReceipt.app.datamodels.PaymentsReceived;
import com.eReceipt.app.fragments.AccountRegistrationFragment;
import com.eReceipt.app.fragments.ConfirmPassCodeFragment;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by developer on 14/7/16.
 */
public class AccountRegistrationActivity extends BaseActivity{
    AccountRegistrationFragment accountRegistrationFragment;
    String passcode="";
    PaymentsReceived paymentsReceived;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);
        initialiseToolbar();
        accountRegistrationFragment = accountRegistrationFragment.newInstance();
        loadFragment(accountRegistrationFragment, R.id.register_container, "Account Registration");
    }

    private void initialiseToolbar() {
        toolBarLayout = (FrameLayout) findViewById(R.id.toolbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar_top);
        searchImage =(ImageView)findViewById(R.id.action_serach);
        searchImage.setVisibility(View.GONE);
        toolbar.setBackgroundColor(getResources().getColor(R.color.splash_background));
        mTitle = (TextView) toolBarLayout.findViewById(R.id.toolbar_title);
        mTitle.setText(getResources().getString(R.string.acct_reg_title));
        mTitle.setTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
    }
}
