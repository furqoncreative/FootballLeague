package com.furqoncreative.kadesubs1.ui.detail

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {
    companion object {
        const val NAME = "name"
        const val LOGO = "logo"
        const val DESC = "desc"
    }

    private var name: String = ""
    private var logo: Int = 0
    private var desc: String = ""

    private lateinit var nameTextView: TextView
    private lateinit var logoImageView: ImageView
    private lateinit var descTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        scrollView {
            lparams(width = matchParent, height = matchParent)
            verticalLayout {
                padding = dip(14)

                logoImageView = imageView().lparams(width = dip(100), height = wrapContent) {
                    gravity = Gravity.CENTER
                }
                nameTextView = textView().lparams(width = wrapContent) {
                    gravity = Gravity.CENTER
                    topMargin = dip(10)
                }
                descTextView = textView().lparams(width = wrapContent) {
                    topMargin = dip(20)
                    leftMargin = dip(20)
                    rightMargin = dip(20)
                    textAlignment = View.TEXT_ALIGNMENT_INHERIT
                }

            }
        }

        logo = intent.getIntExtra(LOGO, 0)
        name = intent.getStringExtra(NAME)
        desc = intent.getStringExtra(DESC)

        Glide.with(logoImageView).load(logo).into(logoImageView)
        nameTextView.text = name
        descTextView.text = desc
    }
}