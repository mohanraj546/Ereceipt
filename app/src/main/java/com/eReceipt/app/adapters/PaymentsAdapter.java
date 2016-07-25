package com.eReceipt.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eReceipt.app.R;
import com.eReceipt.app.datamodels.CompanyObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by developer on 18/7/16.
 */
public class PaymentsAdapter extends RecyclerView.Adapter<PaymentsAdapter.PaymentItemHolder> {
    private LayoutInflater inflater;
    private Context context;
    private View.OnClickListener listener;
    CompanyObject companyObject;
    ArrayList<CompanyObject> companyObjectArrayList = new ArrayList<CompanyObject>();


    public View.OnClickListener getListener() {
        return listener;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public PaymentsAdapter(Context context, ArrayList<CompanyObject> list) {
        this.context = context;
        this.companyObjectArrayList = list;
    }

    @Override
    public PaymentItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.payment_adapter_item, parent, false);
        return new PaymentItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PaymentItemHolder holder, int position) {
        companyObject = companyObjectArrayList.get(position);
        holder.tv_company_name.setText(companyObject.getCompany_name());
        holder.tv_company_details.setText(companyObject.getCompany_manufacturer());
        holder.tv_invoice_count.setText(companyObject.getInvoice_count());

        holder.ll_company.setOnClickListener(getListener());
        holder.ll_company.setTag(companyObject);
        holder.ll_invoice.setOnClickListener(getListener());
        holder.ll_invoice.setTag(companyObject);
    }


    public class PaymentItemHolder extends RecyclerView.ViewHolder {
        public TextView tv_company_name, tv_company_details, tv_invoice_count;
        public LinearLayout ll_company,ll_invoice;

        public PaymentItemHolder(View view) {
            super(view);
            tv_company_name = (TextView) view.findViewById(R.id.tv_company_name_pay_item);
            tv_company_details = (TextView) view.findViewById(R.id.tv_company_details_pay_item);
            tv_invoice_count = (TextView) view.findViewById(R.id.tv_invoice_count);
            ll_company = (LinearLayout)view.findViewById(R.id.ll_company);
            ll_invoice=(LinearLayout)view.findViewById(R.id.ll_invoice);
        }
    }

    @Override
    public int getItemCount() {
        return companyObjectArrayList.size();
    }
}
