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
import com.eReceipt.app.activities.PassCodeActivity;
import com.eReceipt.app.adapters.Gridview_dialer_adapter;

/**
 * Created by developer on 13/7/16.
 */
public class ActivationCodeFragment extends Fragment implements View.OnClickListener{
    GridView gridView_dialer;
    Gridview_dialer_adapter gridview_dialer_adapter;
    TextView tv_phone_number,tv_activate_account,tv_plz_enter_ph_no;
    String str_phone_number="";
    ImageView iv_close;
    RelativeLayout rel_activate_account;

    public static ActivationCodeFragment newInstance() {
        ActivationCodeFragment fragment = new ActivationCodeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View activation_code_view = inflater.inflate(R.layout.fragment_create_account, container, false);
        initializeViews(activation_code_view);
        setDataToViews();
        return activation_code_view;
    }

    private void initializeViews(View activation_code_view) {
        gridView_dialer = (GridView)activation_code_view.findViewById(R.id.gridview_dialer);
        tv_phone_number = (TextView)activation_code_view.findViewById(R.id.tv_phone_number);
        iv_close = (ImageView)activation_code_view.findViewById(R.id.iv_close);
        rel_activate_account=(RelativeLayout)activation_code_view.findViewById(R.id.rel_register);
        tv_activate_account = (TextView)activation_code_view.findViewById(R.id.tv_register);
        tv_plz_enter_ph_no = (TextView)activation_code_view.findViewById(R.id.tv_plz_enter_ph_no);
        gridview_dialer_adapter = new Gridview_dialer_adapter(getActivity());
        iv_close.setOnClickListener(this);
        rel_activate_account.setOnClickListener(this);
    }

    private void setDataToViews() {
        tv_plz_enter_ph_no.setText(getResources().getString(R.string.activation_code_enter_actv_code));
        tv_activate_account.setText(getResources().getString(R.string.activation_code_account));
        gridView_dialer.setAdapter(gridview_dialer_adapter);
        gridView_dialer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (tv_phone_number.length() < 5) {
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
            case R.id.rel_register:
                if(tv_phone_number.length()==5){
                    loadPassCodeScreen();
                }else{
                    Toast.makeText(getActivity(), getResources().getString(R.string.activation_code_valid_code), Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
    private void loadPassCodeScreen() {
        Intent passcode_screen = new Intent(getActivity(), PassCodeActivity.class);
        startActivity(passcode_screen);
        getActivity().finish();
    }
}
