package com.elopez.pokemonpurchaseapp

import com.elopez.pokemonfeature.model.PokemonData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {
    @GET("api/v2/pokemon/{name}")
    suspend fun getPokemonData(@Path("name") name: String): Response<PokemonData>

}