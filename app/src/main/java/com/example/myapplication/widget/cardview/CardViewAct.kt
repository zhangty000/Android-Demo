package com.example.myapplication.widget.cardview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActCardViewBinding

class CardViewAct : AppCompatActivity() {

    private val vb by lazy{
        ActCardViewBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vb.root)
    }
}