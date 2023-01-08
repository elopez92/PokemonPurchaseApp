package com.elopez.pokemonpurchaseapp.model

data class User(
    var name: String,
    var last: String,
    val accountNumber: Int,
    var balance: Double,
    var email: String
) {
}