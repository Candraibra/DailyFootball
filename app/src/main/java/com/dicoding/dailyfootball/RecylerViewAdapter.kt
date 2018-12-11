package com.dicoding.dailyfootball

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext


class RecyclerViewAdapter(private val context: Context, private val clubs: List<Club>, private val listener: (Club) -> Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemUI().createView(AnkoContext.create(context, parent)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(clubs[position], listener)
    }

    override fun getItemCount(): Int = clubs.size

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
            LayoutContainer {

        var tvName: TextView = itemView.findViewById(ItemUI.tvName)
        var ivImage: ImageView = itemView.findViewById(ItemUI.ivImage)

        fun bindItem(items: Club, listener: (Club) -> Unit) {
            tvName.text = items.name
            Glide.with(containerView).load(items.image).into(ivImage)
            containerView.setOnClickListener { listener(items) }
        }
    }
}