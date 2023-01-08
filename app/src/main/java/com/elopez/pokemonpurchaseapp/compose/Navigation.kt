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
            if(viewModel.changeScreens.value){
                //Toast.makeText(LocalContext.current, "Pokemon found", Toast.LENGTH_SHORT).show()
                navController.navigate(Screen.PurchaseSummaryScreen.withArgs())
                viewModel.changeScreens.value = false
            }
        }
        composable(route = Screen.PurchaseSummaryScreen.route)
        {
            PurchaseSummaryScreen(viewModel)
        }
    }
}