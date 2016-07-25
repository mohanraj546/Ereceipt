package com.eReceipt.app.fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.eReceipt.app.R;
import com.eReceipt.app.activities.InvoiceListActivity;
import com.eReceipt.app.datamodels.CompanyObject;
import com.eReceipt.app.datamodels.EreceiptSessiondata;
import com.eReceipt.app.datamodels.InvoiceDetail;
import com.eReceipt.app.interfaces.CompanyDetailsListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by developer on 22/7/16.
 */
public class InvoiceDetailFragment extends Fragment implements View.OnClickListener {

    TableLayout table_layout;
    String[] inv_det_array;
    ArrayList<InvoiceDetail> invoiceDetailArrayList = new ArrayList<InvoiceDetail>();
    TableRow tr = null;
    TableLayout.LayoutParams tlparams;
    TextView tv_sub_total_amount,tv_tax_amount,tv_others_amount,tv_others1_amount,tv_grand_total_amount,
            tv_received_amount_total,tv_bal_due_amount;
    float sub_total_amount,tax_percentage,bal_due_amount;

    public static InvoiceDetailFragment newInstance() {
        InvoiceDetailFragment fragment = new InvoiceDetailFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inv_details_view = inflater.inflate(R.layout.fragment_invoice_detail, container, false);
        initializeViews(inv_details_view);
        setDataToViews();
        return inv_details_view;
    }

    private void initializeViews(View inv_details_view) {
        table_layout = (TableLayout)inv_details_view.findViewById(R.id.tableLayout);

        tv_sub_total_amount = (TextView)inv_details_view.findViewById(R.id.tv_sub_total_amount);
        tv_tax_amount = (TextView)inv_details_view.findViewById(R.id.tv_tax_amount);
        tv_others_amount = (TextView)inv_details_view.findViewById(R.id.tv_others_amount);
        tv_others1_amount = (TextView)inv_details_view.findViewById(R.id.tv_others1_amount);
        tv_grand_total_amount = (TextView)inv_details_view.findViewById(R.id.tv_grand_total_amount);
        tv_received_amount_total = (TextView)inv_details_view.findViewById(R.id.tv_received_amount_total);
        tv_bal_due_amount = (TextView)inv_details_view.findViewById(R.id.tv_bal_due_amount);
    }

    private void setDataToViews() {

        EreceiptSessiondata.getSessionDataInstance().setInvoiceDetail_Item();
        invoiceDetailArrayList=EreceiptSessiondata.getSessionDataInstance().getInvoiceDetail_Item();
        inv_det_array = getResources().getStringArray(R.array.inv_det_array);


       tlparams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                        TableLayout.LayoutParams.MATCH_PARENT, 1.0f);

        TableRow.LayoutParams trparams = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1.0f);
        tr = new TableRow(getActivity());
        tr.setLayoutParams(tlparams);
        tr.setBackgroundColor(getResources().getColor(R.color.cust_entry_form_cancel_solid_color));
        tr.setPadding(30, 30, 30, 30);
        //tr.setGravity(Gravity.CENTER);


        for(int i=0;i<inv_det_array.length;i++){
            TextView tv = new TextView(getActivity());
            tv.setTextAppearance(getActivity(), R.style.helvetica_bold_font);
            tv.setText(inv_det_array[i]);
            tv.setTextColor(Color.WHITE);
            tv.setLayoutParams(trparams);
            tv.setGravity(Gravity.CENTER);
            tr.addView(tv);
        }

        table_layout.addView(tr);

        for(int i=0;i<invoiceDetailArrayList.size();i++){

            InvoiceDetail invoiceDetail = invoiceDetailArrayList.get(i);

            String[] array_invoiceDetail = {invoiceDetail.getSno(),invoiceDetail.getItem_name(),
            invoiceDetail.getQty(),invoiceDetail.getRate(),invoiceDetail.getAmount()};

            sub_total_amount = sub_total_amount + Float.parseFloat(invoiceDetail.getAmount());

            TableRow tableRow = getTableRow();

            for(int j=0;j<5;j++){
                TextView textView = getTextView(tableRow);
                textView.setText(array_invoiceDetail[j]);
                textView.setLayoutParams(trparams);
                tableRow.addView(textView);
            }

            table_layout.addView(tableRow);
        }

        tax_percentage = (sub_total_amount*5)/100;
        bal_due_amount = (sub_total_amount+tax_percentage-2000.00f);

        tv_sub_total_amount.setText(""+sub_total_amount);
        tv_tax_amount.setText(""+tax_percentage);
        tv_grand_total_amount.setText(""+(sub_total_amount+tax_percentage));
        tv_received_amount_total.setText(""+2000.00);
        tv_bal_due_amount.setText(""+bal_due_amount);
    }

    private TextView getTextView(TableRow tableRow) {
        TextView tv = new TextView(getActivity());
        tv.setTextAppearance(getActivity(), R.style.helvetica_regular_font);
        tv.setTextColor(getResources().getColor(R.color.create_account_enter_ph_no));
        tv.setGravity(Gravity.CENTER);
        return tv;
    }

    private TableRow getTableRow() {
        tr = new TableRow(getActivity());
        tr.setLayoutParams(tlparams);
        tr.setPadding(30, 30, 30, 30);
        tr.setGravity(Gravity.CENTER);
        return tr;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
        }
    }
}
