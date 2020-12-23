package com.example.paging.ui.main

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.paging.data.model.Data
import kotlinx.android.synthetic.main.item_news.view.*

class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: Data?, position: Int) {
        itemView.tvTitle.text = "$position _____ ${item?.date}"
    }
}