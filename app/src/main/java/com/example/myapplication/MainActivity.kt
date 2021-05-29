package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.dialog.DialogAct
import com.example.myapplication.image.ImageMainAct
import com.example.myapplication.kotlin.xc.XcMainAct
import com.example.myapplication.text.ChildTextClickAct
import com.example.myapplication.text.TextSpaceAct
import com.example.myapplication.widget.clickeffcect.ClickEffectAct
import com.example.myapplication.widget.cardview.CardViewAct
import com.example.myapplication.widget.rv.RvTestAct
import com.example.myapplication.zhuan_chang.TransitionAnimationAct

class MainActivity : AppCompatActivity() {

    private val vb by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vb.root)
        addBtn("点击特效", ClickEffectAct::class.java)
        addBtn("CardView",CardViewAct::class.java)
        addBtn("RV", RvTestAct::class.java)
        addBtn("图片", ImageMainAct::class.java)
        addBtn("协程", XcMainAct::class.java)
        addBtn("弹窗", DialogAct::class.java)
        addBtn("部分文字点击事件", ChildTextClickAct::class.java)
        addBtn("EditText文字分段显示",TextSpaceAct::class.java)
        addBtn("Act转场动画",TransitionAnimationAct::class.java)
    }

    private fun addBtn(text:String, clazz: Class<*>){
        val btn = Button(this)
        btn.text = text
        btn.isAllCaps = false
        btn.setOnClickListener {
            startActivity(Intent(this,clazz))
        }
        vb.llyMain.addView(btn)
    }
}
