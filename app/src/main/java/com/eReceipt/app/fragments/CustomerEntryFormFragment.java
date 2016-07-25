package com.eReceipt.app.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.eReceipt.app.R;
import com.eReceipt.app.adapters.PaymentsAdapter;
import com.eReceipt.app.datamodels.EreceiptSessiondata;

/**
 * Created by developer on 20/7/16.
 */
public class CustomerEntryFormFragment extends Fragment implements View.OnClickListener {

    TextView tv_add_new_item,textView_item;
    LinearLayout linearLayout_items;
    int count=0;
    Spinner spn_companies;
    String[] companies = {"Sv Manufacturing","Anrak Aluminium","Wellness Zone","Yeturu Biotech LTD","Sri Vanapamu Vari Shop"};

    public static CustomerEntryFormFragment newInstance() {
        CustomerEntryFormFragment fragment = new CustomerEntryFormFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View cust_form_view = inflater.inflate(R.layout.fragment_customer_entry_form, container, false);
        initializeViews(cust_form_view);
        setDataToViews();
        return cust_form_view;
    }

    private void initializeViews(View cust_form_view) {
        spn_companies = (Spinner)cust_form_view.findViewById(R.id.spn_companies);
        tv_add_new_item = (TextView)cust_form_view.findViewById(R.id.tv_add_new_item);
        linearLayout_items = (LinearLayout)cust_form_view.findViewById(R.id.ll_items);
        tv_add_new_item.setOnClickListener(this);
    }

    private void setDataToViews() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, companies);
        spn_companies.setAdapter(adapter);
        addItems(count);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_add_new_item:
                count++;
                if(count<=5)
                addItems(count);
        }
    }

    private void addItems(int count) {
        for (int i=count;i<=count;i++){
            LinearLayout.LayoutParams rlp = new
                    LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            rlp.setMargins(0,getResources().getDimensionPixelSize(R.dimen.cus_ent_frm_item1_mar_top),0,0);
            View child = getActivity().getLayoutInflater().inflate(R.layout.item, null);
            textView_item = (TextView)child.findViewById(R.id.tv_item1);
            textView_item.setText("Item"+" "+(i+1));
            child.setLayoutParams(rlp);
            linearLayout_items.addView(child,i);
        }
    }
}
