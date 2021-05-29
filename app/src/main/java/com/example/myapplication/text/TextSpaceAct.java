package com.example.myapplication.text;

import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActTextSpaceBinding;
import com.example.myapplication.utils.LogUtils;
import com.example.myapplication.utils.PhoneTextUtil;

public class TextSpaceAct extends AppCompatActivity {
    private ActTextSpaceBinding vb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vb = ActTextSpaceBinding.inflate(getLayoutInflater());
        setContentView(vb.getRoot());
        PhoneTextUtil.setPhoneStyleEt(vb.etTextSpaceAct);
        SpannableString text = new SpannableString("123456789");
        LogUtils.w("text:" + text);
//        text.setSpan(new SpaceSpan(),0,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        text.setSpan(new SpaceSpan(),3,4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        text.setSpan(new SpaceSpan(),6,7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        vb.et2TextSpaceAct.setText(text);
        vb.btnGetEtText.setOnClickListener((v -> getEtText()));
    }

    private void getEtText() {
        LogUtils.w("et2内容：" + vb.et2TextSpaceAct.getText());
    }
}