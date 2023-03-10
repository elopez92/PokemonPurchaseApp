package com.elopez.pokemonpurchaseapp.model

import android.os.Parcelable
import com.elopez.pokemonfeature.model.Other
import com.elopez.pokemonfeature.model.Versions
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sprites(
    val back_default: String,
    val back_female: String,
    val back_shiny: String,
    val back_shiny_female: String,
    val front_default: String,
    val front_female: String,
    val front_shiny: String,
    val front_shiny_female: String,
    val other: Other,
    val versions: Versions
): Parcelable