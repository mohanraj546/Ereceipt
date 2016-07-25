package com.eReceipt.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.eReceipt.app.R;

/**
 * Created by developer on 12/7/16.
 */
public class Gridview_dialer_adapter extends BaseAdapter {
    private Context mContext;

    // Keep all Images in array
    public static String[] mThumbIds = {"1","2","3","4","5","6","7","8","9","","0","*"};

    // Constructor
    public Gridview_dialer_adapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;

        if (convertView == null) {

            gridView = new View(mContext);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.gridview_item, null);

            // set value into textview
            TextView textView = (TextView) gridView
                    .findViewById(R.id.tv_item);
            textView.setText(mThumbIds[position]);

        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }
}
