package com.eReceipt.app.fragments;


import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eReceipt.app.R;
import com.eReceipt.app.activities.CompanyDetailsActivity;
import com.eReceipt.app.activities.InvoiceListActivity;
import com.eReceipt.app.datamodels.CompanyObject;
import com.eReceipt.app.interfaces.CompanyDetailsListener;

/**
 * Created by developer on 19/7/16.
 */
public class CompanyDetailFragment extends Fragment implements View.OnClickListener{

    TextView tv_company_name;
    RelativeLayout relativeLayout_invoices,relativeLayout_contacts;
    CompanyObject companyObject;
    CompanyDetailsListener companyDetailsListener;

    public static CompanyDetailFragment newInstance(CompanyObject companyObject) {
        CompanyDetailFragment fragment = new CompanyDetailFragment();
        Bundle bundleCompanyData = new Bundle();
        bundleCompanyData.putSerializable("CompanyObject", companyObject);
        fragment.setArguments(bundleCompanyData);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View comp_details_view = inflater.inflate(R.layout.fragment_company_details, container, false);
        companyObject = (CompanyObject) getArguments().getSerializable("CompanyObject");
        initializeViews(comp_details_view);
        setDataToViews();
        return comp_details_view;
    }

    private void initializeViews(View comp_details_view) {

        tv_company_name = (TextView)comp_details_view.findViewById(R.id.tv_company_name);
        relativeLayout_contacts = (RelativeLayout)comp_details_view.findViewById(R.id.rel_contacts);
        relativeLayout_invoices = (RelativeLayout)comp_details_view.findViewById(R.id.rel_invoices);

        relativeLayout_invoices.setOnClickListener(this);
        relativeLayout_contacts.setOnClickListener(this);
    }

    private void setDataToViews() {
        tv_company_name.setText(companyObject.getCompany_name());
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (companyDetailsListener == null) {
            companyDetailsListener = (CompanyDetailsListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        companyDetailsListener = null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rel_contacts :
                companyDetailsListener.loadContactListFragment();
                break;
            case R.id.rel_invoices :
                //companyDetailsListener.loadInvoicesListFragment();
                Intent invoicelist= new Intent(getActivity(), InvoiceListActivity.class);
                startActivity(invoicelist);
                break;
        }
    }
}
