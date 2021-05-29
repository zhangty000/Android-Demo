package com.example.myapplication.drawable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityDrawableBinding

class DrawableAct : AppCompatActivity() {

    private val vb by lazy{
        ActivityDrawableBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vb.root)
    }
}