package com.elopez.pokemonfeature.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Icons(
    val front_default: String,
    val front_female: String
): Parcelable