package com.example.myapplication.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.utils.LogUtils;

public class SpaceSpan extends ReplacementSpan {

    /**
     * @param text TextView所需要显示的总字符串
     * @param start span在text的起始位置
     * @param end span在text的截止位置
     * @param fm 画笔的字体设置
     * */
    @Override
    public int getSize(@NonNull Paint paint, CharSequence text, int start, int end, @Nullable Paint.FontMetricsInt fm) {
        StringBuffer sb = new StringBuffer();
        CharSequence spanText = text.subSequence(start, end);
        LogUtils.w("spanText:" + spanText);
        sb.append(' ').append(spanText);
        float width
                = paint.measureText(sb, 0, sb.length());
        return (int) (width + 0.5f);
    }

    @Override
    public void draw(@NonNull Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, @NonNull Paint paint) {
        LogUtils.w("draw触发start:" + start + " end:" + end );
        StringBuffer sb = new StringBuffer();
        sb.append(' ').append(text.subSequence(start,end));
        canvas.drawText(sb,0,sb.length(),x,y,paint);
    }
}
