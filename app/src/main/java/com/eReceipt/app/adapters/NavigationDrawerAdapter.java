package com.eReceipt.app.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eReceipt.app.R;
import com.eReceipt.app.datamodels.NavigationItem;

import java.util.Collections;
import java.util.List;


public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.MyViewHolder> {
    public List<NavigationItem> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;
    private String inbox;
    private boolean isChildVisible;

    public NavigationDrawerAdapter(Context context, List<NavigationItem> data, String inbox) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.inbox = inbox;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.nav_drawer_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        NavigationItem currentNavigationItem = data.get(position);
        holder.title.setText(currentNavigationItem.getName());

        /*if (position == 3) {
            holder.iv_arrow.setBackgroundResource(R.drawable.arrow_down);
            if (isChildVisible) {
                if (holder.ll_child.getVisibility() == View.GONE)
                    holder.ll_child.setVisibility(View.VISIBLE);
                else
                    holder.ll_child.setVisibility(View.GONE);
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("item click", "item click");

                    if (holder.ll_child.getVisibility() == View.GONE) {
                        isChildVisible = true;
                        holder.iv_arrow.setBackgroundResource(R.drawable.arrow_up);
                        holder.ll_child.setVisibility(View.VISIBLE);
                    } else {
                        isChildVisible = false;
                        holder.iv_arrow.setBackgroundResource(R.drawable.arrow_down);
                        holder.ll_child.setVisibility(View.GONE);
                    }
                }
            });
        } else {
            holder.itemView.setOnClickListener(null);
            holder.ll_child.setVisibility(View.GONE);
        }*/
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        View separator_line;
        //ImageView iv_arrow;
        //LinearLayout ll_child;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.nav_item_txt);
            separator_line = (View)itemView.findViewById(R.id.separator_line);
            //ll_child = (LinearLayout)itemView.findViewById(R.id.ll_child);
           // iv_arrow = (ImageView)itemView.findViewById(R.id.iv_arrow);
        }
    }
}
