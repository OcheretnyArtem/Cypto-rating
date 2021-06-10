package com.uogames.lesson23.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class SimpleViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun setData(itemView: View,any:T)

}