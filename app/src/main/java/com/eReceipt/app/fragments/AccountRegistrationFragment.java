package com.eReceipt.app.fragments;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.eReceipt.app.R;
import com.eReceipt.app.activities.MyCustomersActivity;
import com.eReceipt.app.datamodels.EreceiptSessiondata;
import com.eReceipt.app.utils.AppConstants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by developer on 14/7/16.
 */
public class AccountRegistrationFragment extends Fragment implements View.OnClickListener{

    EditText edt_name,edt_desg,edt_abt_desg,edt_mobile,edt_email,edt_cmpy_name,edt_address,edt_cmpy_mobile,edt_cmpy_mail;
    RelativeLayout rel_save;

    public static AccountRegistrationFragment newInstance() {
        AccountRegistrationFragment fragment = new AccountRegistrationFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View acct_reg_view = inflater.inflate(R.layout.fragment_account_registration, container, false);
        initializeViews(acct_reg_view);
        setDataToViews();
        return acct_reg_view;
    }

    private void initializeViews(View acct_reg_view) {
        edt_name = (EditText)acct_reg_view.findViewById(R.id.edt_name);
        edt_desg = (EditText)acct_reg_view.findViewById(R.id.edt_desg);
        edt_abt_desg = (EditText)acct_reg_view.findViewById(R.id.edt_abt_desg);
        edt_mobile = (EditText)acct_reg_view.findViewById(R.id.edt_mobile);
        edt_email = (EditText)acct_reg_view.findViewById(R.id.edt_email);
        edt_cmpy_name = (EditText)acct_reg_view.findViewById(R.id.edt_cmpy_name);
        edt_address = (EditText)acct_reg_view.findViewById(R.id.edt_cmpy_address);
        edt_cmpy_mobile = (EditText)acct_reg_view.findViewById(R.id.edt_cmpy_mobile);
        edt_cmpy_mail = (EditText)acct_reg_view.findViewById(R.id.edt_cmpy_email);
        rel_save = (RelativeLayout)acct_reg_view.findViewById(R.id.rel_save);
        rel_save.setOnClickListener(this);
    }

    private void setDataToViews() {
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rel_save:
                 validation();
                break;
        }
    }

    private void validation() {
        if(edt_name.length()<1){
            Toast.makeText(getActivity(),getResources().getString(R.string.acct_reg_plz_enr_name),Toast.LENGTH_SHORT).show();
        }else if(edt_desg.length()<1){
            Toast.makeText(getActivity(),getResources().getString(R.string.acct_reg_plz_enr_desg),Toast.LENGTH_SHORT).show();
        }else if(edt_abt_desg.length()<1){
            Toast.makeText(getActivity(),getResources().getString(R.string.acct_reg_plz_enr_abt_desg),Toast.LENGTH_SHORT).show();
        }else if(edt_mobile.length()<1){
            Toast.makeText(getActivity(),getResources().getString(R.string.acct_reg_plz_enr_mob),Toast.LENGTH_SHORT).show();
        }else if(edt_email.length()<1){
            Toast.makeText(getActivity(),getResources().getString(R.string.acct_reg_plz_enr_email),Toast.LENGTH_SHORT).show();
        }else if(edt_cmpy_name.length()<1){
            Toast.makeText(getActivity(),getResources().getString(R.string.acct_reg_plz_enr_cmpy_name),Toast.LENGTH_SHORT).show();
        }else if(edt_address.length()<1){
            Toast.makeText(getActivity(),getResources().getString(R.string.acct_reg_plz_enr_addr),Toast.LENGTH_SHORT).show();
        }else if(edt_cmpy_mobile.length()<1){
            Toast.makeText(getActivity(),getResources().getString(R.string.acct_reg_plz_enr_cmpy_mobile),Toast.LENGTH_SHORT).show();
        }else if(edt_cmpy_mail.length()<1){
            Toast.makeText(getActivity(),getResources().getString(R.string.acct_reg_plz_enr_cmpy_email),Toast.LENGTH_SHORT).show();
        }else if(edt_mobile.length()!=10){
            Toast.makeText(getActivity(),getResources().getString(R.string.acct_reg_plz_enr_valid_mob),Toast.LENGTH_SHORT).show();
        }else if(edt_cmpy_mobile.length()!=10){
            Toast.makeText(getActivity(),getResources().getString(R.string.acct_reg_plz_enr_valid_mob),Toast.LENGTH_SHORT).show();
        }else if(!emailValidator(edt_email.getText().toString())){
            Toast.makeText(getActivity(),getResources().getString(R.string.acct_reg_plz_enr_valid_email),Toast.LENGTH_SHORT).show();
        }else if(!emailValidator(edt_cmpy_mail.getText().toString())){
            Toast.makeText(getActivity(),getResources().getString(R.string.acct_reg_plz_enr_valid_email),Toast.LENGTH_SHORT).show();
        }else{
            showThanksDialog();
        }
    }

    private void showThanksDialog() {
        final Dialog dialog = new Dialog(getActivity(),R.style.CustomDialog);

        //setting custom layout to dialog
        dialog.setContentView(R.layout.thanks_dialog);
        ImageView image = (ImageView)dialog.findViewById(R.id.iv_go);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadMyCustomersScreen();
            }
        });

        dialog.show();
    }

    private void loadMyCustomersScreen() {
        EreceiptSessiondata.setFromWhichScreen(AppConstants.MY_CUSTOMERS_SCREEN);
        Intent mycustomers_screen = new Intent(getActivity(), MyCustomersActivity.class);
        startActivity(mycustomers_screen);
        getActivity().finish();
    }

    public boolean emailValidator(String email)
    {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
