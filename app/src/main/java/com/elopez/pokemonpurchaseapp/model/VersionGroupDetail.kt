package com.elopez.pokemonfeature.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VersionGroupDetail(
    val level_learned_at: Int,
    val move_learn_method: MoveLearnMethod,
    val version_group: VersionGroup
): Parcelable