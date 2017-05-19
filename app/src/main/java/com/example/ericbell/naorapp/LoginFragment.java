package com.example.ericbell.naorapp;


import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends DialogFragment {

    EditText etUserName, etPassword;
    Button btnSignIn, btnCancel,barcaicon;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_login_fragment,container,false);
        setCancelable(false);

        return v ;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etPassword = (EditText) view.findViewById(R.id.etPassword);
        etUserName = (EditText) view.findViewById(R.id.etUserName);

        //buttons
        btnCancel = (Button) view.findViewById(R.id.btnCancel);
        btnSignIn = (Button) view.findViewById(R.id.btnSignIn);

        //setLisnteners buttons


        btnCancel.setOnClickListener(cancelListener);
        btnSignIn.setOnClickListener(signInListener);




    }


    View.OnClickListener cancelListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dismiss();

        }
    };

    View.OnClickListener signInListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            CharSequence userName = etUserName.getText();
            if (userName.length() <= 3) {
                etUserName.setError("Most At Least 3 Charcters");
                return;
            }

            Toast.makeText(getContext(),etUserName.getText(),Toast.LENGTH_SHORT).show();
            dismiss();
        }
    };


}
