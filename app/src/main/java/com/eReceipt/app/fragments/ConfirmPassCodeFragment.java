package com.eReceipt.app.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.eReceipt.app.activities.AccountRegistrationActivity;
import com.eReceipt.app.activities.MyCustomersActivity;
import com.eReceipt.app.activities.PassCodeActivity;
import com.eReceipt.app.adapters.Gridview_dialer_adapter;

/**
 * Created by developer on 13/7/16.
 */
public class ConfirmPassCodeFragment extends Fragment implements View.OnClickListener{
    GridView gridView_dialer;
    Gridview_dialer_adapter gridview_dialer_adapter;
    TextView tv_phone_number,tv_confirm,tv_plz_enter_passcode;
    String str_phone_number="";
    ImageView iv_close;
    RelativeLayout rel_confirm;
    String passcode="";

    public static ConfirmPassCodeFragment newInstance() {
        ConfirmPassCodeFragment fragment = new ConfirmPassCodeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            passcode= bundle.getString("passcode");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View confirm_passcode_view = inflater.inflate(R.layout.fragment_create_account, container, false);
        initializeViews(confirm_passcode_view);
        setDataToViews();
        return confirm_passcode_view;
    }

    private void initializeViews(View confirm_passcode_view) {
        gridView_dialer = (GridView)confirm_passcode_view.findViewById(R.id.gridview_dialer);
        tv_phone_number = (TextView)confirm_passcode_view.findViewById(R.id.tv_phone_number);
        iv_close = (ImageView)confirm_passcode_view.findViewById(R.id.iv_close);
        tv_confirm = (TextView)confirm_passcode_view.findViewById(R.id.tv_register);
        tv_plz_enter_passcode = (TextView)confirm_passcode_view.findViewById(R.id.tv_plz_enter_ph_no);
        rel_confirm = (RelativeLayout)confirm_passcode_view.findViewById(R.id.rel_register);
        gridview_dialer_adapter = new Gridview_dialer_adapter(getActivity());
        iv_close.setOnClickListener(this);
        rel_confirm.setOnClickListener(this);
    }

    private void setDataToViews() {
        tv_confirm.setText(getResources().getString(R.string.passcode_confirm));
        tv_plz_enter_passcode.setText(getResources().getString(R.string.confirm_passcode_enter_cnf_code));
        gridView_dialer.setAdapter(gridview_dialer_adapter);
        gridView_dialer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (tv_phone_number.length() < 4) {
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
                if(tv_phone_number.length()==4){
                    if(tv_phone_number.getText().toString().equals(passcode))
                    {
                        loadCustomersScreen();
                    }else{
                        Toast.makeText(getActivity(), getResources().getString(R.string.confirm_passcode_valid), Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getActivity(), getResources().getString(R.string.passcode_valid), Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
    private void loadCustomersScreen() {
        Intent account_reg = new Intent(getActivity(), AccountRegistrationActivity.class);
        startActivity(account_reg);
        getActivity().finish();
    }
}
