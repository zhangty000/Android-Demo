package com.example.myapplication.net

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActLoadImageBinding

class LoadImageAct : AppCompatActivity() {

    private val vb by lazy {
        ActLoadImageBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vb.root)
        vb.btnOkHttpLoadImage.setOnClickListener {

        }
    }
}