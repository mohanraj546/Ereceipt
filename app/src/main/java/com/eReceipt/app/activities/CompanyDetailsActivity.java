package com.eReceipt.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.eReceipt.app.R;
import com.eReceipt.app.datamodels.CompanyObject;
import com.eReceipt.app.datamodels.EreceiptSessiondata;
import com.eReceipt.app.fragments.CompanyDetailFragment;
import com.eReceipt.app.fragments.ContactDetailFragment;
import com.eReceipt.app.fragments.ContactListFragment;
import com.eReceipt.app.fragments.InvoicesListFragment;
import com.eReceipt.app.interfaces.CompanyDetailsListener;
import com.eReceipt.app.interfaces.ContactDetailListener;
import com.eReceipt.app.utils.AppConstants;

/**
 * Created by developer on 19/7/16.
 */
public class CompanyDetailsActivity extends BaseActivity implements CompanyDetailsListener,ContactDetailListener {
    CompanyDetailFragment companyDetailFragment;
    ContactListFragment contactListFragment;
    ContactDetailFragment contactDetailFragment;
    InvoicesListFragment invoicesListFragment;
    CompanyObject companyObject;
    String str_From_Which_Screen="";

    @Override
    public void loadInvoicesListFragment() {
        invoicesListFragment = InvoicesListFragment.newInstance();
        mTitle.setText(getResources().getString(R.string.inv_list_title));
        loadFragmentByAddingToBackStack(invoicesListFragment, R.id.register_container, "Invoice List");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_details);
        companyObject = (CompanyObject)getIntent().getSerializableExtra("CompanyObject");

        toolBarLayout = (FrameLayout) findViewById(R.id.toolbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar_top);

        str_From_Which_Screen = EreceiptSessiondata.getFromWhichScreen();

        if(str_From_Which_Screen!= null){
            if(str_From_Which_Screen.equals(AppConstants.MY_CUSTOMERS_SCREEN) || str_From_Which_Screen.equals(AppConstants.PAYMENTS_RECEIVED_SCREEN))
            {
                toolbar.setBackgroundColor(getResources().getColor(R.color.pay_rcv_tool_bar_bg));
                setColorToStatusBar(getResources().getColor(R.color.pay_rcv_tool_bar_bg));
            }else{
                toolbar.setBackgroundColor(getResources().getColor(R.color.pay_gvn_tool_bar_bg));
                setColorToStatusBar(getResources().getColor(R.color.pay_gvn_tool_bar_bg));
            }
        }

        mTitle = (TextView) toolBarLayout.findViewById(R.id.toolbar_title);
        mTitle.setText(companyObject.getCompany_name());
        setGravityLeft();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        companyDetailFragment = CompanyDetailFragment.newInstance(companyObject);
        loadFragment(companyDetailFragment, R.id.register_container, "Company Detail");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                getSupportFragmentManager().popBackStack();
                //setTitle();
                mTitle.setText(companyObject.getCompany_name());
            } else
                //finish the activity
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
            mTitle.setText(companyObject.getCompany_name());
            //setTitle();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void loadContactListFragment() {
        contactListFragment = ContactListFragment.newInstance();
        mTitle.setText(getResources().getString(R.string.cont_list_cont_title));
        loadFragmentByAddingToBackStack(contactListFragment, R.id.register_container, "Contact List");
    }

    @Override
    public void loadContactDetail() {
        Intent loadContactDetail = new Intent(this,ContactDetailActivity.class);
        startActivity(loadContactDetail);
    }
}
