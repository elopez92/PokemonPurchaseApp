package com.elopez.pokemonfeature.model

import android.os.Parcelable
import com.elopez.pokemonpurchaseapp.model.Silver
import kotlinx.parcelize.Parcelize

@Parcelize
data class GenerationIi(
    val crystal: Crystal,
    val gold: Gold,
    val silver: Silver
): Parcelable