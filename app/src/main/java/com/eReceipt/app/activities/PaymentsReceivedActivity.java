package com.eReceipt.app.activities;

import android.os.Bundle;

import com.eReceipt.app.R;
import com.eReceipt.app.fragments.PaymentsReceivedFragment;

/**
 * Created by developer on 18/7/16.
 */
public class PaymentsReceivedActivity extends BaseNavigationActivity {
    PaymentsReceivedFragment paymentsReceivedFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar.setBackgroundColor(getResources().getColor(R.color.pay_rcv_tool_bar_bg));
        setGravityLeft();
        mTitle.setText(getResources().getString(R.string.pay_rcv_title));
        paymentsReceivedFragment = PaymentsReceivedFragment.newInstance();
        loadFragment(paymentsReceivedFragment, R.id.container_body, "Payments Received");
        setColorToStatusBar(getResources().getColor(R.color.pay_rcv_tool_bar_bg));
    }
}
