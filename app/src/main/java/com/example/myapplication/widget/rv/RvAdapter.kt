package com.example.myapplication.widget.rv

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.example.myapplication.R

class RvAdapter(var count:Int = 0) : BaseQuickAdapter<Object,BaseViewHolder>(R.layout.item_rv){
    override fun convert(holder: BaseViewHolder, item: Object) {
        (holder.itemView as TextView).text = "第${holder.adapterPosition + 1}条"
    }


    override fun getDefItemCount(): Int {
        return count
    }
}