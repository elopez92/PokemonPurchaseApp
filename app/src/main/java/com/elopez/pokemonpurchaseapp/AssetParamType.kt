package com.elopez.pokemonpurchaseapp

import android.os.Bundle
import androidx.navigation.NavType
import com.elopez.pokemonpurchaseapp.model.PokemonData
import com.google.gson.Gson

class AssetParamType: NavType<PokemonData>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): PokemonData? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): PokemonData {
        return Gson().fromJson(value, PokemonData::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: PokemonData) {
       bundle.putParcelable(key, value)
    }

}