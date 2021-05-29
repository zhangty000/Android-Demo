package com.example.myapplication.zhuan_chang

import android.os.Bundle
import android.transition.Slide
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.utils.ActAnimUtils


class SecondTAAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initTransition()
        setContentView(R.layout.activity_second_t_a)
    }

    private fun initTransition() {
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)//允许使用转场动画
        when(intent.getStringExtra("transition")){
            "slide"->{
                val slide = Slide()
                slide.duration = 500
                window.enterTransition = slide
            }
        }
    }

    override fun finish() {
        super.finish()
        //第一个动画为上Act的进入动画，第二个动画为当前Act的退出动画
        ActAnimUtils.setActAnim(ActAnimUtils.ANIM_STYLE_DOWN,this)
    }
}