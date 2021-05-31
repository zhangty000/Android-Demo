package com.example.myapplication.widget.clickeffcect

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class RvAdp(count:Int, itemLayoutId:Int, var itemConvertListener: (BaseViewHolder, String) -> Unit) : BaseQuickAdapter<String,BaseViewHolder>(itemLayoutId) {
    init {
        val data = mutableListOf<String>()
        val range = 0 until count
        for (i in range){
            data.add("第${i+1}条")
        }
        setNewInstance(data)
    }

    override fun convert(holder: BaseViewHolder, item: String) {
        itemConvertListener(holder,item)
    }

}