package com.example.myapplication.widget.clickeffcect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.myapplication.R
import com.example.myapplication.databinding.ActClickEffectBinding

class ClickEffectAct : AppCompatActivity() {

    private val vb by lazy {
        ActClickEffectBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(vb.root)
        vb.rvClickEffectAct.layoutManager = LinearLayoutManager(this)
        vb.rvClickEffectAct.adapter =
            RvAdp(20, R.layout.click_effect_rv_item) { holder: BaseViewHolder, item: String ->
                (holder.itemView as TextView).text = item
            }
    }
}