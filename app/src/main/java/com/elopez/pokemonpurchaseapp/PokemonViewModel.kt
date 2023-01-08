package com.elopez.pokemonpurchaseapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elopez.pokemonpurchaseapp.model.PokemonData
import com.elopez.pokemonpurchaseapp.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PokemonViewModel: ViewModel() {
    val user = User(name = "Ash", last="Ketchum", accountNumber = 1234567890, balance = 1000.0, email="email@yahoo.com")
    val pokemonNotExist = mutableStateOf(false)
    var pokemonResponse: PokemonData by mutableStateOf(PokemonData())
    var name: String by mutableStateOf("")

    val loading = mutableStateOf(false)
    val changeScreens = mutableStateOf(false)

    val retService = RetrofitInstance.getRetrofitInstance().create(PokemonApi::class.java)

    fun getPokemonData(){
        viewModelScope.launch(Dispatchers.IO){
            withContext(Dispatchers.Main){
                loading.value = true
            }
            val response = retService.getPokemonData(name.lowercase())
            if(response.body() == null){
                pokemonNotExist.value = true
            }else {
                pokemonNotExist.value = false
                pokemonResponse = response.body()!!
                withContext(Dispatchers.Main){
                    changeScreens.value = true
                }
            }
            withContext(Dispatchers.Main){
                loading.value = false
            }
        }
    }
}