package com.example.myapplication.act

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityActStackBinding

//Activity栈
class ActStackAct : AppCompatActivity() {

    private val vb by lazy {
        ActivityActStackBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vb.root)
        vb.btnGetStackName.setOnClickListener {
//            ActivityStack
//            packageManager.getActivityInfo(localClassName,)
//            activitytaskAffinity
        }
    }
}