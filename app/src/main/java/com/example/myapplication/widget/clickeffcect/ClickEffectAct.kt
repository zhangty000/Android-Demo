package com.example.myapplication.widget.clickeffcect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.ActClickEffectBinding
import com.example.myapplication.widget.rv.RvAdapter

class ClickEffectAct : AppCompatActivity() {

    private val vb by lazy {
        ActClickEffectBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vb.root)
        vb.rvClickEffectAct.layoutManager = LinearLayoutManager(this);
    }
}