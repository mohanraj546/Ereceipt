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
import com.eReceipt.app.datamodels.CompanyObject;
import com.eReceipt.app.datamodels.EreceiptSessiondata;
import com.eReceipt.app.fragments.ArchiveInvoiceListFragment;
import com.eReceipt.app.fragments.CompanyDetailFragment;
import com.eReceipt.app.fragments.CompletedInvoiceListFragment;
import com.eReceipt.app.fragments.PendingInvoiceListFragment;
import com.eReceipt.app.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by developer on 19/7/16.
 */
public class InvoiceListActivity extends BaseActivity {

    private TabLayout tabLayout;
    private ViewPager invoice_list_pager;
    String str_From_Which_Screen = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invoice_list);

        toolBarLayout = (FrameLayout) findViewById(R.id.toolbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar_top);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        invoice_list_pager = (ViewPager) findViewById(R.id.viewpager);

        str_From_Which_Screen = EreceiptSessiondata.getFromWhichScreen();

        if(str_From_Which_Screen!= null){
            if(str_From_Which_Screen.equals(AppConstants.MY_CUSTOMERS_SCREEN) || str_From_Which_Screen.equals(AppConstants.PAYMENTS_RECEIVED_SCREEN))
            {
                toolbar.setBackgroundColor(getResources().getColor(R.color.pay_rcv_tool_bar_bg));
                setColorToStatusBar(getResources().getColor(R.color.pay_rcv_tool_bar_bg));
                tabLayout.setBackgroundColor(getResources().getColor(R.color.pay_rcv_tool_bar_bg));
            }else{
                toolbar.setBackgroundColor(getResources().getColor(R.color.pay_gvn_tool_bar_bg));
                setColorToStatusBar(getResources().getColor(R.color.pay_gvn_tool_bar_bg));
                tabLayout.setBackgroundColor(getResources().getColor(R.color.pay_gvn_tool_bar_bg));
            }
        }

        mTitle = (TextView) toolBarLayout.findViewById(R.id.toolbar_title);
        mTitle.setText(getResources().getString(R.string.inv_list_title));
        setGravityLeft();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tabLayout.setupWithViewPager(invoice_list_pager);
        setupViewPager(invoice_list_pager);
        setUptabColors();
    }

    private void setUptabColors() {
            TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
            tabOne.setText("Pending");
            tabLayout.getTabAt(0).setCustomView(tabOne);

            TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
            tabTwo.setText("Completed");
            tabLayout.getTabAt(1).setCustomView(tabTwo);

            TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
            tabThree.setText("Archive");
            tabLayout.getTabAt(2).setCustomView(tabThree);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new PendingInvoiceListFragment(), "Pending");
        adapter.addFragment(new CompletedInvoiceListFragment(), "Completed");
        adapter.addFragment(new ArchiveInvoiceListFragment(), "Archive");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
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
