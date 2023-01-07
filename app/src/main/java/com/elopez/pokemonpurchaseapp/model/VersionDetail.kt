package com.elopez.pokemonfeature.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VersionDetail(
    val rarity: Int,
    val version: Version
): Parcelable