package com.example.myapplication.image

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActImageFunction1Binding
import com.example.myapplication.utils.GlideUtils

class ImageFunction1Act : AppCompatActivity() {

    private val vb by lazy {
        ActImageFunction1Binding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vb.root)
        val url =
            "https://th.bing.com/th/id/R2fb169b9731afa2b73bb1dc5244cd6c8?rik=cgzcpqBJX%2b3YYg&riu=http%3a%2f%2fimg.xinminweekly.com.cn%2f2020%2f12%2f30%2f20201230134311327671.jpg&ehk=5d7gSrKGXsZnQMYr%2b5ibYmqqRDw7Qk4LvYsObThTh7s%3d&risl=&pid=ImgRaw"
//            "https://inews.gtimg.com/newsapp_bt/0/12869954732/1000"
        vb.etImgUrl.setText(url)
        vb.btnLoadImgNormalSetting.setOnClickListener { loadImageNormalSetting() }
        vb.btnLoadImgCenterCrop.setOnClickListener { loadImageCenterCrop() }
        vb.btnLoadImgWithRadius.setOnClickListener { loadImgWithRadius() }
        vb.btnLoadImgCenterCropWithRadius.setOnClickListener { loadImageCenterCropWithRadius() }
        vb.btnLoadImgWithBorder.setOnClickListener { loadImgWithBorder() }
        vb.btnClearCache.setOnClickListener { clearCache() }
    }

    private fun clearCache() {
        GlideUtils.clearCache(application)
    }


    private fun loadImageNormalSetting() {
        var imgUrl = vb.etImgUrl.text.toString()
        GlideUtils.loadImage(vb.ivImage,imgUrl,null);
    }

    private fun loadImageCenterCrop() {
        var imgUrl = vb.etImgUrl.text.toString()
        GlideUtils.loadImageCenterCorp(vb.ivImage,imgUrl)
    }

    private fun loadImgWithRadius() {
        var imgUrl = vb.etImgUrl.text.toString()
        GlideUtils.loadImageWithRadius(vb.ivImage,imgUrl,20)
    }

    private fun loadImageCenterCropWithRadius() {
        var imgUrl = vb.etImgUrl.text.toString()
        GlideUtils.loadImageCenterCropWithRadius(vb.ivImage,imgUrl,20)
    }


    private fun loadImgWithBorder() {
        var imgUrl = vb.etImgUrl.text.toString()
        GlideUtils.loadImageWithBorder(vb.ivImage,imgUrl,20,8)
    }







}