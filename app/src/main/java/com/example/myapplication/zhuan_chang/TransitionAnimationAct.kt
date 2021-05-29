package com.example.myapplication.zhuan_chang

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActTransitionAnimationBinding
import com.example.myapplication.utils.ActAnimUtils

class TransitionAnimationAct : AppCompatActivity() {

    private val vb by lazy {
        ActTransitionAnimationBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vb.root)
    }

    fun defaultTA(view: View) {
        startActivity(Intent(this, SecondTAAct::class.java))
    }

    fun tranAnim1(view: View) {
        val intent = Intent(this, SecondTAAct::class.java)
//        intent.putExtra("transition", "slide")
        startActivity(intent)
        //第一个动画为下一个Act的进入动画，第二个动画为当前Act的退出动画
        ActAnimUtils.setActAnim(ActAnimUtils.ANIM_STYLE_UP,this)
    }
}