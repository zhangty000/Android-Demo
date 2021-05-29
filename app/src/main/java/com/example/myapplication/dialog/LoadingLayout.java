package com.example.myapplication.dialog;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class LoadingLayout extends LinearLayout {

    public LoadingLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        needCompute = true;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (needCompute){
            if (w != h && w != 0){
                int size = w > h ? w : h;
                ViewGroup.LayoutParams lp = getLayoutParams();
                lp.width = size;
                lp.height = size;
                requestLayout();
            }
            needCompute = false;
        }
    }

    private boolean needCompute;

    public void resetSize(){
        needCompute = true;
        ViewGroup.LayoutParams lp = getLayoutParams();
        lp.width = WRAP_CONTENT;
        lp.height = WRAP_CONTENT;
        requestLayout();
    }
}
