package com.example.myapplication.text;

import android.content.Context;
import android.text.InputFilter;
import android.text.Spanned;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.Filter;

public class SpaceEt extends androidx.appcompat.widget.AppCompatEditText {
    public SpaceEt(Context context) {
        super(context);
        init();
    }

    public SpaceEt(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
//        setFilters(new InputFilter[]{new SpanFilter()});
    }

    private class SpanFilter implements InputFilter {
        @Override
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            return null;
        }
    }
}
