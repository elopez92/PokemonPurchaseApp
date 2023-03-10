package com.elopez.pokemonpurchaseapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.elopez.pokemonpurchaseapp.compose.Navigation
import com.elopez.pokemonpurchaseapp.ui.theme.PokemonPurchaseAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel by viewModels<PokemonViewModel>()
        setContent {
            PokemonPurchaseAppTheme(){
                Navigation(viewModel = viewModel)
            }
        }
    }
}
