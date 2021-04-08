package com.liverpool.app.presentation.ui.search

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.liverpool.app.R
import com.liverpool.app.domain.models.Record
import com.liverpool.app.presentation.utils.formatPrice
import kotlinx.android.synthetic.main.item_search.view.*

class SearchAdapter(val context: Context) : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    var searchs: MutableList<Record> = mutableListOf()

    fun updateSearch(stores: List<Record>) {
        this.searchs.clear()
        this.searchs.addAll(stores)
        notifyDataSetChanged()
    }

    internal var clickSearch: (Record) -> Unit = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) =
        ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_search, parent, false))

    override fun getItemCount(): Int = searchs.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val store = this.searchs[position]
        holder.bindView(
            store,
            clickSearch
        )

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SetTextI18n")
        fun bindView(
            search: Record,
            clickSearch: (Record) -> Unit
        ) =
            with(this.itemView) {
                setOnClickListener { clickSearch(search) }
                Glide.with(this)
                    .load(search.xlImage)
                    .centerCrop()
                    .into(thumbnail)
                productDisplayName.text = search.productDisplayName
                price.text = search.minimumListPrice.formatPrice()
            }

    }

}