package com.elopez.pokemonfeature.model

import android.os.Parcelable
import com.elopez.pokemonpurchaseapp.model.RubySapphire
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GenerationIii(
    val emerald: Emerald,
    @SerializedName("firered-leafgreen")
    val firered_leafgreen: FireredLeafgreen,
    @SerializedName("ruby-sapphire")
    val ruby_sapphire: RubySapphire
): Parcelable