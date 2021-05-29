package com.example.myapplication.widget.rv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityRvTestBinding

class RvTestAct : AppCompatActivity() {

    private val vb  by lazy {
        ActivityRvTestBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vb.root)
        initView();
    }

    private fun initView() {
        vb.rv1RvTestAct.layoutManager = LinearLayoutManager(this)
        vb.rv1RvTestAct.adapter = RvAdapter(20)
    }
}