package com.elopez.pokemonfeature.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonData(
    var abilities: List<Ability>? = null,
    var base_experience: Int = 0,
    var forms: List<Form>? = emptyList(),
    var game_indices: List<GameIndice>? = emptyList(),
    var height: Int = 0,
    var held_items: List<HeldItem>? = emptyList(),
    var id: Int = 0,
    var is_default: Boolean = false,
    var location_area_encounters: String? = null,
    var moves: List<Move>? = emptyList(),
    var name: String? = null,
    var order: Int = 0,
    var past_types: List<String>? = emptyList(),
    var species: Species? = null,
    var sprites: Sprites? = null,
    var stats: List<Stat>? = emptyList(),
    var types: List<Type>? = emptyList(),
    var weight: Int = 0
): Parcelable