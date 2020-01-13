package com.furqoncreative.kadesubs1.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LeagueItem(
    val name: String?, val logo: Int?, val desc: String?
) : Parcelable