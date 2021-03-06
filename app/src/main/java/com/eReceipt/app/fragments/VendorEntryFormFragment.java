package com.eReceipt.app.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.eReceipt.app.R;

/**
 * Created by developer on 21/7/16.
 */
public class VendorEntryFormFragment extends Fragment implements View.OnClickListener {

    TextView tv_add_new_item,textView_item;
    LinearLayout linearLayout_items;
    int count=0;
    Spinner spn_companies;
    String[] companies = {"Sv Manufacturing","Anrak Aluminium","Wellness Zone","Yeturu Biotech LTD","Sri Vanapamu Vari Shop"};


    public static VendorEntryFormFragment newInstance() {
        VendorEntryFormFragment fragment = new VendorEntryFormFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View ven_form_view = inflater.inflate(R.layout.fragment_customer_entry_form, container, false);
        initializeViews(ven_form_view);
        setDataToViews();
        return ven_form_view;
    }

    private void initializeViews(View ven_form_view) {
        spn_companies = (Spinner)ven_form_view.findViewById(R.id.spn_companies);
        tv_add_new_item = (TextView)ven_form_view.findViewById(R.id.tv_add_new_item);
        linearLayout_items = (LinearLayout)ven_form_view.findViewById(R.id.ll_items);
        tv_add_new_item.setOnClickListener(this);
    }

    private void setDataToViews() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
               R.layout.spinner_item, companies);
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
