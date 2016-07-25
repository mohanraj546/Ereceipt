package com.eReceipt.app.fragments;

import android.content.Context;
import android.content.Intent;
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
import com.eReceipt.app.activities.AddContactActivity;
import com.eReceipt.app.adapters.ContactsAdapter;
import com.eReceipt.app.adapters.PaymentsAdapter;
import com.eReceipt.app.datamodels.ContactObject;
import com.eReceipt.app.datamodels.EreceiptSessiondata;
import com.eReceipt.app.interfaces.ContactDetailListener;
import com.eReceipt.app.utils.AppConstants;

import java.util.ArrayList;

/**
 * Created by developer on 19/7/16.
 */
public class ContactListFragment extends Fragment implements View.OnClickListener{

    RecyclerView recyclerView_contact_list;
    ContactObject contactObject=new ContactObject();
    ArrayList<ContactObject> contactObjectArrayList = new ArrayList<ContactObject>();
    ContactsAdapter contactsAdapter;
    FloatingActionButton floatingActionButton;
    String str_From_Which_Screen = "";
    ContactDetailListener contactDetailListener;

    public static ContactListFragment newInstance() {
        ContactListFragment fragment = new ContactListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View cont_list_view = inflater.inflate(R.layout.fragment_contact_list, container, false);
        initializeViews(cont_list_view);
        setDataToViews();
        return cont_list_view;
    }

    private void initializeViews(View cont_list_view) {
        floatingActionButton = (FloatingActionButton)cont_list_view.findViewById(R.id.float_btn_add_contact);
        floatingActionButton.setOnClickListener(this);
        recyclerView_contact_list = (RecyclerView)cont_list_view.findViewById(R.id.recy_view_contact_list);
        EreceiptSessiondata.getSessionDataInstance().setContactObjectList();
        contactObjectArrayList = EreceiptSessiondata.getSessionDataInstance().getContactObjectList();
        contactsAdapter = new ContactsAdapter(getActivity(), contactObjectArrayList);
    }

    private void setDataToViews() {

        str_From_Which_Screen = EreceiptSessiondata.getFromWhichScreen();

        if(str_From_Which_Screen !=null){
            if(str_From_Which_Screen.equals(AppConstants.MY_CUSTOMERS_SCREEN) || str_From_Which_Screen.equals(AppConstants.PAYMENTS_RECEIVED_SCREEN))
            {
                floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.pay_rcv_tool_bar_bg)));
            }else{
                floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.pay_gvn_tool_bar_bg)));
            }
        }
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView_contact_list.setLayoutManager(mLayoutManager);
        contactsAdapter.setListener(this);
        recyclerView_contact_list.setAdapter(contactsAdapter);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (contactDetailListener == null) {
            contactDetailListener = (ContactDetailListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        contactDetailListener = null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.float_btn_add_contact :
                loadAddContact();
                break;

            case R.id.rel_contact_item :
                contactDetailListener.loadContactDetail();
                break;
        }
    }
    private void loadAddContact() {
        Intent add_contact = new Intent(getActivity(), AddContactActivity.class);
        startActivity(add_contact);
    }
}
