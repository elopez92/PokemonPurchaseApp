package com.elopez.pokemonpurchaseapp.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.elopez.pokemonpurchaseapp.PokemonViewModel
import com.elopez.pokemonpurchaseapp.ui.theme.Typography
import com.elopez.pokemonpurchaseapp.ui.theme.pokemonFont

@Composable
fun BaseScreen(
    viewModel: PokemonViewModel,
    loading: State<Boolean>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column{
            TextFieldView(viewModel)
            OutlinedButton(onClick = { viewModel.getPokemonData() },
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)) {
                    Text("Buy", color = Color.Black, fontFamily = pokemonFont, fontSize = 16.sp)
                    PaddingValues(16.dp)
            }
        }
    }
}

@Composable
fun TextFieldView(viewModel: PokemonViewModel){

    OutlinedTextField(
        value = viewModel.name,
        onValueChange = {
            viewModel.name = it
        },
        label = { Text("Enter Pokemon name", fontFamily = pokemonFont)},
        textStyle = TextStyle(color = Color.Black, fontSize = 16.sp, fontFamily = pokemonFont, letterSpacing = 2.sp)
    )
}