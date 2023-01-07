package com.elopez.pokemonfeature.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
): Parcelable