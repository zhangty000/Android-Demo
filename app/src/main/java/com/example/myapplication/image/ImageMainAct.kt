package com.example.myapplication.image

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.databinding.ActImageMainBinding

class ImageMainAct : AppCompatActivity() {

    private val vb by lazy{
        ActImageMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vb.root)
        vb.btnFunction1.setOnClickListener { toFunction1() }
    }

    private fun toFunction1() {
        startActivity(Intent(this,ImageFunction1Act::class.java))
    }
}