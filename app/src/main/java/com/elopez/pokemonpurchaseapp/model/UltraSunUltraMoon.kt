package com.elopez.pokemonfeature.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UltraSunUltraMoon(
    val front_default: String,
    val front_female: String,
    val front_shiny: String,
    val front_shiny_female: String
): Parcelable