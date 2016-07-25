package com.eReceipt.app.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eReceipt.app.R;
import com.eReceipt.app.adapters.ContactsAdapter;
import com.eReceipt.app.datamodels.ContactObject;
import com.eReceipt.app.datamodels.EreceiptSessiondata;

import java.util.ArrayList;

/**
 * Created by developer on 19/7/16.
 */
public class InvoicesListFragment extends Fragment implements View.OnClickListener{

    RecyclerView recyclerView_contact_list;
    ContactObject contactObject=new ContactObject();
    ArrayList<ContactObject> contactObjectArrayList = new ArrayList<ContactObject>();
    ContactsAdapter contactsAdapter;

    public static InvoicesListFragment newInstance() {
        InvoicesListFragment fragment = new InvoicesListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View invoice_list_view = inflater.inflate(R.layout.fragment_contact_list, container, false);
        initializeViews(invoice_list_view);
        setDataToViews();
        return invoice_list_view;
    }

    private void initializeViews(View cont_list_view) {
        recyclerView_contact_list = (RecyclerView)cont_list_view.findViewById(R.id.recy_view_contact_list);
        EreceiptSessiondata.getSessionDataInstance().setContactObjectList();
        contactObjectArrayList = EreceiptSessiondata.getSessionDataInstance().getContactObjectList();
        contactsAdapter = new ContactsAdapter(getActivity(), contactObjectArrayList);
    }

    private void setDataToViews() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView_contact_list.setLayoutManager(mLayoutManager);
        contactsAdapter.setListener(this);
        recyclerView_contact_list.setAdapter(contactsAdapter);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

        }
    }
}
