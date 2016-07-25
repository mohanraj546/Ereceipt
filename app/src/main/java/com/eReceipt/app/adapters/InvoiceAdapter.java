package com.eReceipt.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eReceipt.app.R;
import com.eReceipt.app.datamodels.ContactObject;
import com.eReceipt.app.datamodels.InvoiceObject;

import java.util.ArrayList;

/**
 * Created by developer on 19/7/16.
 */
public class InvoiceAdapter extends RecyclerView.Adapter<InvoiceAdapter.InvoiceItemHolder> {

    private LayoutInflater inflater;
    private Context context;
    private View.OnClickListener listener;
    InvoiceObject invoiceObject;
    ArrayList<InvoiceObject> invoiceObjectArrayList = new ArrayList<InvoiceObject>();


    public View.OnClickListener getListener() {
        return listener;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public InvoiceAdapter(Context context, ArrayList<InvoiceObject> list) {
        this.context = context;
        this.invoiceObjectArrayList = list;
    }

    @Override
    public InvoiceItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.invoice_item, parent, false);
        return new InvoiceItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(InvoiceItemHolder holder, int position) {
        invoiceObject = invoiceObjectArrayList.get(position);
        holder.tv_invoice_number.setText(invoiceObject.getInvoiceNumber());
        holder.tv_invoice_date.setText(invoiceObject.getInvoiceDate());
        holder.tv_invoice_amount.setText(context.getResources().getString(R.string.rupee_symbol)+invoiceObject.getInvoiceAmount());
        holder.rel_invoice_item.setOnClickListener(getListener());
        holder.rel_invoice_item.setTag(invoiceObject);
    }

    public class InvoiceItemHolder extends RecyclerView.ViewHolder {
        public TextView tv_invoice_number, tv_invoice_date,tv_invoice_amount;
        RelativeLayout rel_invoice_item;

        public InvoiceItemHolder(View view) {
            super(view);
            tv_invoice_number = (TextView) view.findViewById(R.id.tv_invoice_number);
            tv_invoice_date = (TextView) view.findViewById(R.id.tv_invoice_date);
            tv_invoice_amount = (TextView)view.findViewById(R.id.tv_invoice_amount);
            rel_invoice_item = (RelativeLayout)view.findViewById(R.id.rel_invoice_item);
        }
    }

    @Override
    public int getItemCount() {
        return invoiceObjectArrayList.size();
    }
}
