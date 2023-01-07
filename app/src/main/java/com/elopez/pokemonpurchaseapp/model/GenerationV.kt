package com.elopez.pokemonfeature.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GenerationV(
    @SerializedName("black-white")
    val black_white: BlackWhite
): Parcelable