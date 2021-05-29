package com.example.myapplication.widget.clickeffcect

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class RvAdp(count:Int,itemLayoutId:Int, var itemConvertListener: ItemConvertListener) : BaseQuickAdapter<String,BaseViewHolder>(itemLayoutId) {
    init {
        val data = mutableListOf<String>()
        val range = 0 until count
        for (i in range){
            data.add("第${i+1}条")
        }
        setNewInstance(data)
    }

    override fun convert(holder: BaseViewHolder, item: String) {
        itemConvertListener.itemConvert(holder,item)
    }

    interface ItemConvertListener{
        fun itemConvert(holder: BaseViewHolder,item:String)
    }
}