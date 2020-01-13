package com.furqoncreative.kadesubs1.ui.main

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.furqoncreative.kadesubs1.R
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class LeagueItemUI : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {

            cardView {
                lparams(width = matchParent, height = wrapContent) {
                    margin = dip(5)
                }

                verticalLayout {
                    lparams(width = matchParent, height = wrapContent)
                    padding = dip(16)
                    orientation = LinearLayout.HORIZONTAL

                    imageView {
                        id = R.id.league_logo
                    }.lparams {
                        height = dip(50)
                        width = dip(50)
                    }

                    textView {
                        id = R.id.league_name
                        textSize = 14f
                    }.lparams {
                        margin = dip(16)
                    }


                }

            }


        }
    }
}