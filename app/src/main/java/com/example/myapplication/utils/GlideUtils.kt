package com.example.myapplication.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.MultiTransformation
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.myapplication.image.RoundedCornersBorder

object GlideUtils {


    fun loadImage(iv: ImageView, url: String, options: RequestOptions?) {
        val load = Glide.with(iv.context)
            .load(url)
        options?.let { load.apply(options) }
        load.into(iv)
    }

    //加载图片，加载完成后显示效果为占满ImageView并且显示图片中间区域
    fun loadImageCenterCorp(iv: ImageView, url: String) {
        val options = RequestOptions().centerCrop();
        loadImage(iv, url, options)
    }

    //加载图片，加载后图片显示圆角
    fun loadImageWithRadius(iv: ImageView, url: String, radius: Int) {
        val options = RequestOptions().transform(RoundedCorners(radius))
        loadImage(iv, url, options)
    }

    //加载图片，展示效果为centerCrop并且有圆角
    fun loadImageCenterCropWithRadius(iv: ImageView, url: String, radius: Int) {
        val tsfCc = CenterCrop();
        val tsfRc = RoundedCorners(radius)
        val options = RequestOptions().transform(MultiTransformation(tsfRc, tsfCc))
        loadImage(iv, url, options)
    }

    //圆形带边框图片
    fun loadImageWithBorder(iv: ImageView, url: String, radius: Int, borderWidth: Int) {
        val options = RequestOptions().transform(RoundedCornersBorder(radius, borderWidth))
//            .diskCacheStrategy(DiskCacheStrategy.NONE)
//            .skipMemoryCache(true)
        loadImage(iv, url, options)
    }

    fun clearCache(context: Context) {
        Glide.get(context).clearMemory()
        Thread() {
            run() {
                Glide.get(context).clearDiskCache()
                LogUtils.e("Glide缓存已清空")
            }
        }.start()
    }
}