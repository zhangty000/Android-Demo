package com.example.myapplication.utils;

import android.app.Activity;

import com.example.myapplication.R;

public class ActAnimUtils {
    public static final int ANIM_STYLE_UP = 1;//上移方式切换动画
    public static final int ANIM_STYLE_DOWN = 2;//下移方式切换动画
    public static void setActAnim(int style, Activity act){
        switch (style){
            case ANIM_STYLE_UP:
                act.overridePendingTransition(R.anim.tran_enter_up, R.anim.tran_exit_up);
                break;
            case ANIM_STYLE_DOWN:
                act.overridePendingTransition(R.anim.tran_enter_down, R.anim.tran_exit_down);
                break;
        }
    }
}
