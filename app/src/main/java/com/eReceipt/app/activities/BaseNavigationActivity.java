package com.eReceipt.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.eReceipt.app.R;
import com.eReceipt.app.datamodels.EreceiptSessiondata;
import com.eReceipt.app.fragments.FragmentDrawer;
import com.eReceipt.app.utils.AppConstants;


public class BaseNavigationActivity extends BaseActivity
        implements FragmentDrawer.FragmentDrawerListener {

    //Defining Variables
    boolean show;
    Fragment fragment = null;
    protected FrameLayout containerlayout;
    protected FragmentDrawer.FragmentDrawerListener drawerListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_navigation);

        // Initializing Toolbar and setting it as the actionbar
        toolBarLayout = (FrameLayout) findViewById(R.id.toolbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar_top);
        toolbar.setBackgroundColor(getResources().getColor(R.color.splash_background));
        searchImage = (ImageView) toolBarLayout.findViewById(R.id.action_serach);
        searchImage.setVisibility(View.VISIBLE);
        mTitle = (TextView) toolBarLayout.findViewById(R.id.toolbar_title);
        mTitle.setText(getResources().getString(R.string.app_name));
        mTitle.setTextColor(getResources().getColor(R.color.white));
        customToolBar = (Toolbar) findViewById(R.id.toolbar_custom);
        customToolBar.setVisibility(View.GONE);
        customToolBar.setBackgroundColor(getResources().getColor(R.color.splash_background));
        setSupportActionBar(customToolBar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        FragmentDrawer drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
        drawerFragment.setDrawerListener(this);

        containerlayout = (FrameLayout) findViewById(R.id.container_body);
        drawerListener = this;

    }

    @Override
    public void setTitle(CharSequence title) {
        super.setTitle(title);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        String title = "";
        if (position != FragmentDrawer.getData().size()) {
            title = ((TextView) view.findViewById(R.id.nav_item_txt)).getText().toString();
        }
        view.setSelected(true);
        displayView(position, title);
    }

    protected void displayView(int position, String title) {
            Fragment fragment = null;
            // set the toolbar title
            mTitle.setText(title);
            if (title.equals(getResources().getString(R.string.nav_drawer_customers))) {
                launchCustomersActivity();
            } else if (title.equals(getResources().getString(R.string.nav_drawer_vendors))) {
                launchVendorsActivity();
            } else if (title.equals(getResources().getString(R.string.nav_drawer_vendor_entry))) {
                launchVendorsEntryFormActivity();;
            } else if (title.equals(getResources().getString(R.string.nav_drawer_customer_entry))) {
                launchCustomersEntryFormActivity();
            }else if (title.equals(getResources().getString(R.string.nav_drawer_pay_rcv))) {
                launchPaymentsReceivedActivity();
            }else if (title.equals(getResources().getString(R.string.nav_drawer_pay_gvn))) {
                launchPaymentsGivenActivity();
            }else if (title.equals(getResources().getString(R.string.nav_drawer_my_acct))) {
                launchMyAccountActivity();
            }else if (title.equals(getResources().getString(R.string.nav_drawer_log_out))) {
                clearData();
            }
    }

    private void launchMyAccountActivity() {
        Intent intent = new Intent(this,MyAccountActivity.class);
        startActivity(intent);
        finish();
    }

    private void clearData() {
        EreceiptSessiondata.getSessionDataInstance().clearData();
        Intent create_account= new Intent(this,CreateAccountActivity.class);
        startActivity(create_account);
        finish();
    }

    private void launchVendorsEntryFormActivity() {
        EreceiptSessiondata.setFromWhichScreen(AppConstants.MY_VENDORS_ENTRY_SCREEN);
        Intent intent = new Intent(this,VendorEntryFormActivity.class);
        startActivity(intent);
        finish();
    }

    private void launchCustomersEntryFormActivity() {
        EreceiptSessiondata.setFromWhichScreen(AppConstants.MY_CUSTOMERS_ENTRY_SCREEN);
        Intent intent = new Intent(this,CustomerEntryFormActivity.class);
        startActivity(intent);
        finish();
    }

    private void launchCustomersActivity() {
        EreceiptSessiondata.setFromWhichScreen(AppConstants.MY_CUSTOMERS_SCREEN);
        Intent intent = new Intent(this,MyCustomersActivity.class);
        startActivity(intent);
        finish();
    }

    private void launchVendorsActivity() {
        EreceiptSessiondata.setFromWhichScreen(AppConstants.MY_VENDORS_SCREEN);
        Intent intent = new Intent(this,MyVendorsActivity.class);
        startActivity(intent);
        finish();
    }

    private void launchPaymentsGivenActivity() {
        EreceiptSessiondata.setFromWhichScreen(AppConstants.PAYMENTS_GIVEN_SCREEN);
        Intent intent = new Intent(this,PaymentsGivenActivity.class);
        startActivity(intent);
        finish();
    }

    private void launchPaymentsReceivedActivity() {
        EreceiptSessiondata.setFromWhichScreen(AppConstants.PAYMENTS_RECEIVED_SCREEN);
        Intent intent = new Intent(this,PaymentsReceivedActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.base_navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_search) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem serachItem = menu.findItem(R.id.action_search);
        serachItem.setVisible(false);
        return true;
    }

    public void addCustomViewToToolBar(View view) {
        mTitle.setVisibility(View.GONE);
        toolbar.setVisibility(View.GONE);
        showOrHideOptionItems(false);
        customToolBar.setVisibility(View.VISIBLE);
        customToolBar.removeAllViews();
        customToolBar.addView(view);
    }

    public void removeCustomView(View view) {
        mTitle.setVisibility(View.VISIBLE);
        if (view != null) {
            customToolBar.setVisibility(View.GONE);
            customToolBar.removeView(view);
        }
        showOrHideOptionItems(true);
        toolbar.setVisibility(View.VISIBLE);
    }

    protected void showOrHideOptionItems(boolean show) {
        this.show = show;
        invalidateOptionsMenu();
    }

}
