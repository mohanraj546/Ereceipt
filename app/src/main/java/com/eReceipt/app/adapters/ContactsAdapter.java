package com.eReceipt.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eReceipt.app.R;
import com.eReceipt.app.datamodels.ContactObject;

import java.util.ArrayList;

/**
 * Created by developer on 19/7/16.
 */
public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactItemHolder> {

    private LayoutInflater inflater;
    private Context context;
    private View.OnClickListener listener;
    ContactObject contactObject;
    ArrayList<ContactObject> contactObjectArrayList = new ArrayList<ContactObject>();


    public View.OnClickListener getListener() {
        return listener;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ContactsAdapter(Context context, ArrayList<ContactObject> list) {
        this.context = context;
        this.contactObjectArrayList = list;
    }

    @Override
    public ContactItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_item, parent, false);
        return new ContactItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ContactItemHolder holder, int position) {
        contactObject = contactObjectArrayList.get(position);
        holder.tv_contact_name.setText(contactObject.getContactName());
        holder.tv_contact_number.setText(contactObject.getContactNumber());
        holder.rel_contact_item.setOnClickListener(getListener());
        holder.rel_contact_item.setTag(contactObject);
    }

    public class ContactItemHolder extends RecyclerView.ViewHolder {
        public TextView tv_contact_name, tv_contact_number;
        RelativeLayout rel_contact_item;

        public ContactItemHolder(View view) {
            super(view);
            tv_contact_name = (TextView) view.findViewById(R.id.tv_contact_name);
            tv_contact_number = (TextView) view.findViewById(R.id.tv_contact_number);
            rel_contact_item = (RelativeLayout)view.findViewById(R.id.rel_contact_item);
        }
    }

    @Override
    public int getItemCount() {
        return contactObjectArrayList.size();
    }
}
