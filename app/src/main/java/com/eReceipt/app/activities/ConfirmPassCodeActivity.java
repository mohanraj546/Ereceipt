package com.eReceipt.app.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.eReceipt.app.R;
import com.eReceipt.app.fragments.ConfirmPassCodeFragment;
import com.eReceipt.app.fragments.PassCodeFragment;

/**
 * Created by developer on 13/7/16.
 */
public class ConfirmPassCodeActivity extends BaseActivity {
    ConfirmPassCodeFragment confirmPassCodeFragment;
    String passcode="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);
        passcode = getIntent().getStringExtra("Passcode");
        initialiseToolbar();
        confirmPassCodeFragment = ConfirmPassCodeFragment.newInstance();
        Bundle b = new Bundle();
        b.putString("passcode",passcode);
        confirmPassCodeFragment.setArguments(b);
        loadFragment(confirmPassCodeFragment, R.id.register_container, "Confirm PassCode");
    }

    private void initialiseToolbar() {
        toolBarLayout = (FrameLayout) findViewById(R.id.toolbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar_top);
        searchImage =(ImageView)findViewById(R.id.action_serach);
        searchImage.setVisibility(View.GONE);
        toolbar.setBackgroundColor(getResources().getColor(R.color.splash_background));
        mTitle = (TextView) toolBarLayout.findViewById(R.id.toolbar_title);
        mTitle.setText(getResources().getString(R.string.confirm_passcode_title));
        mTitle.setTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
    }
}
