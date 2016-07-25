package com.eReceipt.app.activities;

import android.os.Bundle;

import com.eReceipt.app.R;
import com.eReceipt.app.fragments.PaymentsGivenFragment;
import com.eReceipt.app.fragments.PaymentsReceivedFragment;

/**
 * Created by developer on 20/7/16.
 */
public class PaymentsGivenActivity extends BaseNavigationActivity{

    PaymentsGivenFragment paymentsGivenFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar.setBackgroundColor(getResources().getColor(R.color.pay_gvn_tool_bar_bg));
        setGravityLeft();
        mTitle.setText(getResources().getString(R.string.pay_gvn_title));
        paymentsGivenFragment = PaymentsGivenFragment.newInstance();
        loadFragment(paymentsGivenFragment, R.id.container_body, "Payments Given");
        setColorToStatusBar(getResources().getColor(R.color.pay_gvn_tool_bar_bg));
    }
}
