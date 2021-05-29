package com.example.myapplication.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.myapplication.R;
import com.example.myapplication.utils.ShapeUtils;


public class LoadingDialog extends AlertDialog {
    private String text;
    private TextView loadingTv;
    private FrameLayout contentView;
    private ProgressBar pb;
    private LoadingLayout loadingLayout;

    protected LoadingDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView = (FrameLayout) LayoutInflater.from(getContext()).inflate(R.layout.dialog_loading, null);
        initView();
        initPb();
        initDialog();
        setContentView(contentView);
//        FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) contentView.getLayoutParams();
//        lp.gravity = Gravity.CENTER;

//        System.out.println("DialogLp:" + lp);
    }

    private void initView() {
        loadingTv = contentView.findViewById(R.id.tv_loadingText);
        int color = getContext().getResources().getColor(R.color.black_b3000000);
        int radius = 16;
        loadingLayout = contentView.findViewById(R.id.parent_loadingDialog);
        loadingLayout.setBackground(ShapeUtils.createRectangleShape(color, radius));
        loadingTv.setText(text);
    }

    private void initDialog() {
        Window window = getWindow();
        window.setBackgroundDrawable(null);
        window.getDecorView().setBackground(null);
        WindowManager.LayoutParams windowLp = window.getAttributes();
        windowLp.dimAmount = 0;
        windowLp.gravity = Gravity.CENTER;
        window.setAttributes(windowLp);
        setCanceledOnTouchOutside(false);
    }

//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        contentView = (LoadingLayout) inflater.inflate(R.layout.dialog_loading, container, false);
//        loadingTv = contentView.findViewById(R.id.tv_loadingText);
//        int color = getResources().getColor(R.color.black_b3000000);
//        int radius = 16;
//        contentView.setBackground(ShapeUtils.createRectangleShape(color, radius));
//        loadingTv.setText(text);
//        pb = contentView.findViewById(R.id.pb_loadingDialog);
//        initPb();
//        return contentView;
//    }

    private void initPb() {
        pb = contentView.findViewById(R.id.pb_loadingDialog);
        pb.setIndeterminateTintMode(PorterDuff.Mode.SRC_ATOP);
        int[] colors = new int[] {Color.WHITE };
        int[][] states = new int[1][];
        states[0] = new int[] {};
        ColorStateList colorList = new ColorStateList(states, colors);
        pb.setIndeterminateTintList(colorList);
    }

//    @NonNull
//    @Override
//    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
//        Dialog dialog = super.onCreateDialog(savedInstanceState);
//        Window window = dialog.getWindow();
//        window.setBackgroundDrawable(null);
//        window.getDecorView().setBackground(null);
//        WindowManager.LayoutParams windowLp = window.getAttributes();
//        windowLp.dimAmount = 0;
//        window.setAttributes(windowLp);
//        dialog.setCanceledOnTouchOutside(false);
//        return dialog;
//    }
//
    public void setText(String text) {
        this.text = text;
        if (loadingTv != null) {
            loadingTv.setText(text);
            loadingLayout.resetSize();
        }
    }

}
