package com.eReceipt.app.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eReceipt.app.R;
import com.eReceipt.app.adapters.InvoiceAdapter;
import com.eReceipt.app.datamodels.EreceiptSessiondata;
import com.eReceipt.app.datamodels.InvoiceObject;

import java.util.ArrayList;

/**
 * Created by developer on 19/7/16.
 */
public class ArchiveInvoiceListFragment extends Fragment implements View.OnClickListener{

    RecyclerView recyclerView_pending_list;
    InvoiceObject invoiceObject=new InvoiceObject();
    ArrayList<InvoiceObject> invoiceObjectArrayList = new ArrayList<InvoiceObject>();
    InvoiceAdapter invoiceAdapter;

    @Override
    public void onClick(View view) {
        switch (view.getId()){

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View peding_list_view = inflater.inflate(R.layout.fragment_invoice_list, container, false);
        initializeViews(peding_list_view);
        setDataToViews();
        return peding_list_view;
    }

    private void initializeViews(View peding_list_view) {
        recyclerView_pending_list = (RecyclerView)peding_list_view.findViewById(R.id.recy_view_invoice_list);
        EreceiptSessiondata.getSessionDataInstance().setPendingInvoiceList();
        invoiceObjectArrayList = EreceiptSessiondata.getSessionDataInstance().getPendingInvoiceList();
        invoiceAdapter = new InvoiceAdapter(getActivity(), invoiceObjectArrayList);
    }

    private void setDataToViews() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView_pending_list.setLayoutManager(mLayoutManager);
        invoiceAdapter.setListener(this);
        recyclerView_pending_list.setAdapter(invoiceAdapter);
    }
}
