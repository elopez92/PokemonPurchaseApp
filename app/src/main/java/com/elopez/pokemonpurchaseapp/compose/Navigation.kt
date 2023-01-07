package com.elopez.pokemonpurchaseapp.compose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.elopez.pokemonpurchaseapp.PokemonViewModel
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.elopez.pokemonpurchaseapp.AssetParamType
import com.elopez.pokemonpurchaseapp.Screen

@Composable
fun Navigation(viewModel: PokemonViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MainScreen.route){
        composable(route = Screen.MainScreen.route) {
            BaseScreen(
                viewModel = viewModel,
                loading = viewModel.loading,
                navController
            )
        }
        composable(
            route = Screen.SummaryScreen.route + "/{summary}",
            arguments = listOf(navArgument("summary")
        {
            type = AssetParamType()
            nullable = false
        }
            )) {
            SummaryScreen()
        }
    }
}