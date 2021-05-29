package com.example.myapplication.dialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityDialogBinding;

public class DialogAct extends AppCompatActivity {
    private ActivityDialogBinding vb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vb = ActivityDialogBinding.inflate(getLayoutInflater());
        setContentView(vb.getRoot());
        vb.btnShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoadingDialog();
            }
        });
    }

    private void showLoadingDialog() {
        showLoading(vb.etDialogAct.getText().toString());
    }


    private LoadingDialog loadingDialog;


    public void showLoading(String text) {

        if (TextUtils.isEmpty(text)){
            text = getString(R.string.connecting_server);
        }
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog(this);
        }
        loadingDialog.setText(text);
        loadingDialog.show();

    }

    public void showLoading(int textRes){
        showLoading(getString(textRes));
    }

    public void hideLoading() {
        if (loadingDialog == null) {
        } else {
            loadingDialog.dismiss();
        }
    }

}