package com.elopez.pokemonpurchaseapp

sealed class Screen(val route: String){
    object MainScreen: Screen("base_screen")
    object PurchaseSummaryScreen: Screen("purchase_summary")

    fun withArgs(vararg args: String): String{
        return buildString{
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
