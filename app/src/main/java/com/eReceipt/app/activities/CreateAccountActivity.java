package com.eReceipt.app.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.eReceipt.app.R;
import com.eReceipt.app.fragments.CreateAccountFragment;

/**
 * Created by developer on 12/7/16.
 */
public class CreateAccountActivity extends BaseActivity {
    CreateAccountFragment createAccountFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);
        initialiseToolbar();
        createAccountFragment = CreateAccountFragment.newInstance();
        loadFragment(createAccountFragment, R.id.register_container, "Create Account");
    }

    private void initialiseToolbar() {
        toolBarLayout = (FrameLayout) findViewById(R.id.toolbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar_top);
        searchImage =(ImageView)findViewById(R.id.action_serach);
        searchImage.setVisibility(View.GONE);
        toolbar.setBackgroundColor(getResources().getColor(R.color.splash_background));
        mTitle = (TextView) toolBarLayout.findViewById(R.id.toolbar_title);
        mTitle.setText(getResources().getString(R.string.create_account_title));
        mTitle.setTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
    }
}
