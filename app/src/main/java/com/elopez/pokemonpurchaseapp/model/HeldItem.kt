package com.elopez.pokemonfeature.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
): Parcelable