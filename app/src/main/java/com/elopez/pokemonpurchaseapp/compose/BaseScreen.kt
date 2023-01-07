package com.elopez.pokemonpurchaseapp.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.TextField
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
            Button(onClick = { viewModel.getPokemonData() }) {
                
            }
        }
    }
}

@Composable
fun TextFieldView(viewModel: PokemonViewModel){

    TextField(
        value = viewModel.name,
        onValueChange = {
            viewModel.name = it
        },
        textStyle = TextStyle(color = Color.Black, fontSize = 16.sp)
    )
}