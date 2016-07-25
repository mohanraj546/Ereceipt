package com.eReceipt.app.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.eReceipt.app.R;
import com.eReceipt.app.activities.ActivationCodeActivity;
import com.eReceipt.app.adapters.Gridview_dialer_adapter;


/**
 * Created by developer on 12/7/16.
 */
public class CreateAccountFragment extends Fragment implements View.OnClickListener{

    GridView gridView_dialer;
    Gridview_dialer_adapter gridview_dialer_adapter;
    TextView tv_phone_number;
    String str_phone_number="";
    ImageView iv_close;
    RelativeLayout rel_register;

    public static CreateAccountFragment newInstance() {
        CreateAccountFragment fragment = new CreateAccountFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View create_account_view = inflater.inflate(R.layout.fragment_create_account, container, false);
        initializeViews(create_account_view);
        setDataToViews();
        return create_account_view;
    }

    private void initializeViews(View registerView) {
        gridView_dialer = (GridView)registerView.findViewById(R.id.gridview_dialer);
        tv_phone_number = (TextView)registerView.findViewById(R.id.tv_phone_number);
        iv_close = (ImageView)registerView.findViewById(R.id.iv_close);
        rel_register = (RelativeLayout)registerView.findViewById(R.id.rel_register);
        gridview_dialer_adapter = new Gridview_dialer_adapter(getActivity());
        iv_close.setOnClickListener(this);
        rel_register.setOnClickListener(this);
    }

    private void setDataToViews() {
        gridView_dialer.setAdapter(gridview_dialer_adapter);
        gridView_dialer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (tv_phone_number.length() <10) {
                    if (i != 11)
                        str_phone_number = str_phone_number + Gridview_dialer_adapter.mThumbIds[i];
                    tv_phone_number.setText(str_phone_number);
                }

                if (i == 11) {
                    if (tv_phone_number.length() > 0) {
                        str_phone_number = str_phone_number.substring(0, str_phone_number.length() - 1);
                        tv_phone_number.setText(str_phone_number);
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_close:
                if(tv_phone_number.length()>0)
                    tv_phone_number.setText("");
                str_phone_number="";
                 break;

            case R.id.rel_register :
                if(tv_phone_number.length()==10){
                    loadActivationScreen();
                }else{
                    Toast.makeText(getActivity(),getResources().getString(R.string.create_account_valid_ph_no),Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void loadActivationScreen() {
        Intent activation_screen = new Intent(getActivity(), ActivationCodeActivity.class);
        startActivity(activation_screen);
        getActivity().finish();
    }
}
