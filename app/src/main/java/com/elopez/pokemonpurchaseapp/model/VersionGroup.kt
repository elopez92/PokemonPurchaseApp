package com.elopez.pokemonfeature.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VersionGroup(
    val name: String,
    val url: String
): Parcelable