package com.elopez.pokemonfeature.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GameIndice(
    val game_index: Int,
    val version: Version
): Parcelable