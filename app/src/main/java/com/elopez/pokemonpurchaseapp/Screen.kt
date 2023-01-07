package com.elopez.pokemonpurchaseapp

sealed class Screen(val route: String){
    object MainScreen: Screen("base_screen")
    object SummaryScreen: Screen("launch_details")

    fun withArgs(vararg args: String): String{
        return buildString{
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
