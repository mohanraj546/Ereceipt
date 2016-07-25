package com.eReceipt.app.fragments;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eReceipt.app.R;
import com.eReceipt.app.adapters.ContactsAdapter;
import com.eReceipt.app.datamodels.EreceiptSessiondata;
import com.eReceipt.app.interfaces.CompanyDetailsListener;
import com.eReceipt.app.interfaces.ContactDetailListener;
import com.eReceipt.app.utils.AppConstants;

/**
 * Created by developer on 21/7/16.
 */
public class ContactDetailFragment extends Fragment implements View.OnClickListener {

    public static ContactDetailFragment newInstance() {
        ContactDetailFragment fragment = new ContactDetailFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View comp_det_view = inflater.inflate(R.layout.fragment_contact_detail, container, false);
        initializeViews(comp_det_view);
        setDataToViews();
        return comp_det_view;
    }

    private void initializeViews(View comp_det_view) {

    }

    private void setDataToViews() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
        }
    }
}
