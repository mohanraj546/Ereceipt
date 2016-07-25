package com.eReceipt.app.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.eReceipt.app.R;
import com.eReceipt.app.datamodels.EreceiptSessiondata;
import com.eReceipt.app.fragments.AddCompanyFragment;
import com.eReceipt.app.fragments.ArchiveInvoiceListFragment;
import com.eReceipt.app.fragments.CompletedInvoiceListFragment;
import com.eReceipt.app.fragments.InvoiceDetailFragment;
import com.eReceipt.app.fragments.PendingInvoiceListFragment;
import com.eReceipt.app.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by developer on 22/7/16.
 */
public class InvoiceDetailActivity extends BaseActivity {

    String str_From_Which_Screen="";
    InvoiceDetailFragment invoiceDetailFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invoice_detail);

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

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        invoiceDetailFragment = InvoiceDetailFragment.newInstance();
        loadFragment(invoiceDetailFragment, R.id.register_container, "Invoice Detail");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
                getSupportFragmentManager().popBackStack();
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
        } else {
            super.onBackPressed();
        }
    }
}
