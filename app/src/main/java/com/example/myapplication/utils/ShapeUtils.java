package com.example.myapplication.utils;

import android.graphics.drawable.GradientDrawable;

public class ShapeUtils {

    //创建一个圆角矩形，color为填充色，后面依次为四个角的圆角半径
    public static GradientDrawable createRectangleShape(int color, float radiu1, float radiu2, float radiu3, float radiu4) {
        GradientDrawable gd = new GradientDrawable();
        gd.setShape(GradientDrawable.RECTANGLE);
        gd.setColor(color);
        gd.setCornerRadii(new float[] {radiu1,radiu1,radiu2,radiu2,radiu3,radiu3,radiu4,radiu4});
        return gd;
    }

    //创建一个矩形shape对象，color为颜色，radius为圆角半径
    public static GradientDrawable createRectangleShape(int color, float radius){
        GradientDrawable gd = new GradientDrawable();
        gd.setShape(GradientDrawable.RECTANGLE);
        gd.setColor(color);
        gd.setCornerRadius(radius);
        return gd;
    }
}
