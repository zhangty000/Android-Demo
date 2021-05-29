package com.example.myapplication.kotlin.xc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.myapplication.databinding.ActXcMainBinding

class XcMainAct : AppCompatActivity() {
    private val vb by lazy{
        ActXcMainBinding.inflate(layoutInflater);
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vb.root)
    }

    fun defaultXc(view: View) {
        
    }


}