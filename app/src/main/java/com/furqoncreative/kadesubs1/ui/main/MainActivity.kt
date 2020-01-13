package com.furqoncreative.kadesubs1.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.furqoncreative.kadesubs1.R
import com.furqoncreative.kadesubs1.model.LeagueItem
import com.furqoncreative.kadesubs1.ui.detail.DetailActivity
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.verticalLayout

class MainActivity : AppCompatActivity() {
    private var items: MutableList<LeagueItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadData()

        verticalLayout {

            recyclerView {
                lparams(width = matchParent, height = matchParent)
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = LeagueAdapter(
                    this@MainActivity,
                    items
                ) { itemClicked(it) }
            }
        }
    }

    private fun loadData() {
        val logo = resources.obtainTypedArray(R.array.league_logo)
        val name = resources.getStringArray(R.array.league_name)
        val desc = resources.getStringArray(R.array.league_description)

        items.clear()
        for (i in name.indices) {
            items.add(
                LeagueItem(
                    name[i],
                    logo.getResourceId(i, 0),
                    desc[i]
                )
            )
        }

        logo.recycle()
    }

    private fun itemClicked(items: LeagueItem) {
        startActivity<DetailActivity>(
            DetailActivity.NAME to items.name,
            DetailActivity.LOGO to items.logo,
            DetailActivity.DESC to items.desc
        )

    }
}