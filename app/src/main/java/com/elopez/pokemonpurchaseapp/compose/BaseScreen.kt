package com.elopez.pokemonpurchaseapp.compose

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.elopez.pokemonfeature.model.Icons
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
    var isError = viewModel.pokemonNotExist.value
    OutlinedTextField(
        value = viewModel.name,
        onValueChange = {
            viewModel.name = it
            isError = false
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        trailingIcon = {
                       if(isError)
                           Icon(androidx.compose.material.icons.Icons.Filled.Warning,"error", tint = MaterialTheme.colors.error)
        },
        singleLine = true,
        isError = isError,
        label = { Text("Enter Pokemon name", fontFamily = pokemonFont)},
        textStyle = TextStyle(color = Color.Black, fontSize = 16.sp, fontFamily = pokemonFont, letterSpacing = 2.sp)
    )
    if(isError || viewModel.pokemonNotExist.value) {
        if(viewModel.pokemonNotExist.value){
            Text(
                text = "Pokemon doesn't exist. Try another.",
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(start = 16.dp),
                fontFamily = pokemonFont
            )
        } else {
            Text(
                text = "Error. Try again",
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(start = 16.dp),
                fontFamily = pokemonFont
            )
        }

    }
}