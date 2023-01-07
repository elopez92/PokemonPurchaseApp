package com.elopez.pokemonfeature.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Emerald(
    val front_default: String,
    val front_shiny: String
): Parcelable