package com.elopez.pokemonpurchaseapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elopez.pokemonfeature.model.PokemonData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokemonViewModel: ViewModel() {
    var pokemonResponse: PokemonData by mutableStateOf(PokemonData())

    val loading = mutableStateOf(false)

    val retService = RetrofitInstance.getRetrofitInstance().create(PokemonApi::class.java)

    fun getPokemonData(name: String){
        viewModelScope.launch(Dispatchers.IO){
            withContext(Dispatchers.Main){
                loading.value = true
            }
            val response = retService.getPokemonData(name)

            pokemonResponse = response.body()!!
            withContext(Dispatchers.Main){
                loading.value = false
            }
        }
    }
}