package com.example.myapplication.text;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActChildTextClickBinding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChildTextClickAct extends AppCompatActivity {
    private ActChildTextClickBinding vb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vb = ActChildTextClickBinding.inflate(getLayoutInflater());
        setContentView(vb.getRoot());

        vb.tvCtcAct.setMovementMethod(MyLinkMovementMethod.getInstance());
        WeiBoContentClickableSpan myClickableSpan = new WeiBoContentClickableSpan(this) {
            @Override
            public void onClick(View widget) {
//                Intent intent = new Intent(context, UserActivity.class);
//                intent.putExtra("nickname",at);
//                intent.putExtra("from","text");
//                context.startActivity(intent);
                        Toast.makeText(ChildTextClickAct.this, "点击了文字", Toast.LENGTH_SHORT).show();
            }
        };
        CharSequence text = vb.tvCtcAct.getText();
        int start = 5;
        int end = 15;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
        spannableStringBuilder.setSpan(myClickableSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        vb.tvCtcAct.setText(spannableStringBuilder);
    }
}