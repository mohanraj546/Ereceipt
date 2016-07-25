package com.eReceipt.app.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eReceipt.app.R;
import com.eReceipt.app.activities.AddCompanyActivity;
import com.eReceipt.app.activities.CompanyDetailsActivity;
import com.eReceipt.app.activities.InvoiceListActivity;
import com.eReceipt.app.adapters.PaymentsAdapter;
import com.eReceipt.app.datamodels.CompanyObject;
import com.eReceipt.app.datamodels.EreceiptSessiondata;

import java.util.ArrayList;

/**
 * Created by developer on 18/7/16.
 */
public class PaymentsReceivedFragment extends Fragment implements  View.OnClickListener{

    RecyclerView recyclerView;
    PaymentsAdapter paymentsAdapter;
    ArrayList<CompanyObject> companyObjects = new ArrayList<CompanyObject>();
    CompanyObject companyObject = new CompanyObject();
    FloatingActionButton floatingActionButton;

    public static PaymentsReceivedFragment newInstance() {
        PaymentsReceivedFragment fragment = new PaymentsReceivedFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View pay_rcv_view = inflater.inflate(R.layout.fragment_payments_received, container, false);
        initializeViews(pay_rcv_view);
        setDataToViews();
        return pay_rcv_view;
    }

    private void initializeViews(View pay_rcv_view) {
        floatingActionButton = (FloatingActionButton)pay_rcv_view.findViewById(R.id.float_btn_add_company);
        floatingActionButton.setOnClickListener(this);
        recyclerView= (RecyclerView)pay_rcv_view.findViewById(R.id.recy_view_pay_rcv);
        EreceiptSessiondata.getSessionDataInstance().setCompanyObjectList();
        companyObjects = EreceiptSessiondata.getSessionDataInstance().getCompanyObjectList();
        paymentsAdapter = new PaymentsAdapter(getActivity(), companyObjects);
    }

    private void setDataToViews() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        paymentsAdapter.setListener(this);
        recyclerView.setAdapter(paymentsAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_company :
                companyObject = (CompanyObject)view.getTag();
                loadCompanyDetails();
                break;
            case R.id.ll_invoice :
                loadInvoicesList();
                break;
            case R.id.float_btn_add_company:
                loadAddCompany();
        }
    }

    private void loadAddCompany() {
        Intent add_company = new Intent(getActivity(), AddCompanyActivity.class);
        startActivity(add_company);
    }

    private void loadInvoicesList() {
        Intent loadInvoicesList = new Intent(getActivity(), InvoiceListActivity.class);
        startActivity(loadInvoicesList);
    }

    private void loadCompanyDetails() {
        Bundle companyObject_bundle = new Bundle();
        companyObject_bundle.putSerializable("CompanyObject",companyObject);
        Intent loadCompanyDetails = new Intent(getActivity(), CompanyDetailsActivity.class);
        loadCompanyDetails.putExtras(companyObject_bundle);
        startActivity(loadCompanyDetails);
    }
}
