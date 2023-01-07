package com.elopez.pokemonfeature.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AbilityX(
    val name: String,
    val url: String
): Parcelable