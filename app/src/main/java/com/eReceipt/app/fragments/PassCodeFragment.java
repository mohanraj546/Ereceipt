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
import com.eReceipt.app.activities.ConfirmPassCodeActivity;
import com.eReceipt.app.activities.PassCodeActivity;
import com.eReceipt.app.adapters.Gridview_dialer_adapter;

/**
 * Created by developer on 13/7/16.
 */
public class PassCodeFragment extends Fragment implements View.OnClickListener{
    GridView gridView_dialer;
    Gridview_dialer_adapter gridview_dialer_adapter;
    TextView tv_phone_number,tv_confirm,tv_plz_enter_passcode;
    String str_phone_number="";
    ImageView iv_close;
    RelativeLayout rel_confirm;

    public static PassCodeFragment newInstance() {
        PassCodeFragment fragment = new PassCodeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View passcode_view = inflater.inflate(R.layout.fragment_create_account, container, false);
        initializeViews(passcode_view);
        setDataToViews();
        return passcode_view;
    }

    private void initializeViews(View passcode_view) {
        gridView_dialer = (GridView)passcode_view.findViewById(R.id.gridview_dialer);
        tv_phone_number = (TextView)passcode_view.findViewById(R.id.tv_phone_number);
        iv_close = (ImageView)passcode_view.findViewById(R.id.iv_close);
        tv_confirm = (TextView)passcode_view.findViewById(R.id.tv_register);
        tv_plz_enter_passcode = (TextView)passcode_view.findViewById(R.id.tv_plz_enter_ph_no);
        rel_confirm = (RelativeLayout)passcode_view.findViewById(R.id.rel_register);
        gridview_dialer_adapter = new Gridview_dialer_adapter(getActivity());
        iv_close.setOnClickListener(this);
        rel_confirm.setOnClickListener(this);
    }

    private void setDataToViews() {
        tv_confirm.setText(getResources().getString(R.string.passcode_confirm));
        tv_plz_enter_passcode.setText(getResources().getString(R.string.passcode_enter_passcode));
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
                    loadConfirmPassCodeScreen();
                }else{
                    Toast.makeText(getActivity(), getResources().getString(R.string.passcode_valid), Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
    private void loadConfirmPassCodeScreen() {
        Intent confirm_passcode_screen = new Intent(getActivity(), ConfirmPassCodeActivity.class);
        confirm_passcode_screen.putExtra("Passcode",tv_phone_number.getText().toString());
        startActivity(confirm_passcode_screen);
        getActivity().finish();
    }
}
