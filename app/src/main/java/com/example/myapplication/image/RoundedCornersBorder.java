package com.example.myapplication.image;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;

import androidx.annotation.NonNull;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import com.bumptech.glide.util.Util;
import com.example.myapplication.utils.LogUtils;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class RoundedCornersBorder extends BitmapTransformation {

    private static final String ID = "com.example.myapplication.image.RoundedCornersBorder";
    private static final byte[] ID_BYTES = ID.getBytes(CHARSET);

    private int roundingRadius;
    private Paint paint;
    private int borderWidth;

    public RoundedCornersBorder(int roundingRadius,int borderWidth) {
        this.roundingRadius = roundingRadius;
        this.borderWidth = borderWidth;
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.borderWidth);
        paint.setColor(Color.RED);
    }

    @Override
    protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        int size = outWidth > outHeight ? outHeight : outWidth;
        BitmapShader bs = new BitmapShader(toTransform, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(bs);
        Bitmap result = Bitmap.createBitmap(size,size,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(size / 2, size / 2,size/2,paint);
        LogUtils.w("开始绘制");
        return result;
    }

    @Override
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);
        byte[] radiusData = ByteBuffer.allocate(4).putInt(roundingRadius).array();
        messageDigest.update(radiusData);
    }

    @Override
    public int hashCode() {
        return Util.hashCode(ID.hashCode(), Util.hashCode(roundingRadius));
    }
}
