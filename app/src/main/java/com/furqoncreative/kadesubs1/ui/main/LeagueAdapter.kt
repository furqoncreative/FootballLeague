package com.furqoncreative.kadesubs1.ui.main

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.furqoncreative.kadesubs1.R
import com.furqoncreative.kadesubs1.model.LeagueItem
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find


class LeagueAdapter(
    context: Context,
    private val items: List<LeagueItem>,
    private val listener: (LeagueItem) -> Unit
) : RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        return LeagueViewHolder(
            LeagueItemUI().createView(
                AnkoContext.create(
                    parent.context,
                    parent
                )
            )
        )
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bindItem(items[position], listener)

    }

    override fun getItemCount(): Int = items.size

    class LeagueViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val leagueLogo: ImageView = view.find(R.id.league_logo)
        private val leagueName: TextView = view.find(R.id.league_name)

        fun bindItem(items: LeagueItem, listener: (LeagueItem) -> Unit) {
            Glide.with(itemView.context)
                .load(items.logo)
                .into(leagueLogo)

            leagueName.text = items.name

            itemView.setOnClickListener {
                listener(items)
            }
        }
    }

}