package com.eReceipt.app.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.eReceipt.app.R;
import com.eReceipt.app.datamodels.CompanyObject;
import com.eReceipt.app.datamodels.EreceiptSessiondata;
import com.eReceipt.app.fragments.AddCompanyFragment;
import com.eReceipt.app.fragments.CompanyDetailFragment;
import com.eReceipt.app.fragments.ContactListFragment;
import com.eReceipt.app.utils.AppConstants;

/**
 * Created by developer on 21/7/16.
 */
public class AddCompanyActivity extends BaseActivity{

    AddCompanyFragment addCompanyFragment;
    String str_From_Which_Screen="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_details);

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
        mTitle.setText(getResources().getString(R.string.add_cmpy_title));
        setGravityLeft();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addCompanyFragment = AddCompanyFragment.newInstance();
        loadFragment(addCompanyFragment, R.id.register_container, "Add Company");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                getSupportFragmentManager().popBackStack();
                //setTitle();
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
            //setTitle();
        } else {
            super.onBackPressed();
        }
    }
}
