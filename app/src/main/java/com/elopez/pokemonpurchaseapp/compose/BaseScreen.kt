package com.elopez.pokemonpurchaseapp.compose

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.elopez.pokemonfeature.model.Icons
import com.elopez.pokemonpurchaseapp.PokemonViewModel
import com.elopez.pokemonpurchaseapp.R
import com.elopez.pokemonpurchaseapp.Screen
import com.elopez.pokemonpurchaseapp.ui.theme.*
import java.text.DecimalFormat

@Composable
fun BaseScreen(
    viewModel: PokemonViewModel,
    loading: State<Boolean>,
    navController: NavController,
    modifier: Modifier = Modifier
) {

    val df = DecimalFormat("#.##")
        val focusManager = LocalFocusManager.current
        Box(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            Image(
            painter = painterResource(id = R.drawable.pok_ball_icon),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.Center)
                .alpha(.1f)
        )
            Column {
                Text(
                    "Welcome ${viewModel.user.name} ${viewModel.user.last}",
                    fontSize = 20.sp,
                    color = BostonUniversityRed,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    textAlign = TextAlign.Center
                )
                fullWidthTextComposable(
                    text1 = "Account number",
                    text2 = viewModel.user.accountNumber
                )
                fullWidthTextComposable(
                    text1 = "Balance",
                    text2 = "$${df.format(viewModel.user.balance)}"
                )

            }
            Column(
                modifier = modifier.align(Alignment.Center)
            ){
                TextFieldView(viewModel, focusManager)
                Button(
                    onClick = {
                        focusManager.clearFocus()
                        viewModel.pokemonNotExist.value = false
                        viewModel.getPokemonData()
                    },
                    modifier = modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(16.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = GoldenYellow)
                ) {
                    Text("Buy", color = Color.Black, fontFamily = pokemonFont, fontSize = 16.sp)
                    PaddingValues(16.dp)
                }
            }
            if(viewModel.notEnough.value){
                AppAlertDialog(viewModel, modifier.align(Alignment.Center))
            }
    }
}

@Composable
fun TextFieldView(viewModel: PokemonViewModel, focusManager: FocusManager){
    var showMessage = viewModel.pokemonNotExist.value
    OutlinedTextField(
        value = viewModel.name,
        onValueChange = {
            viewModel.name = it
            showMessage = false
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        keyboardActions = KeyboardActions(
            onDone = {
            focusManager.clearFocus() ;
            viewModel.getPokemonData()
            }),
        trailingIcon = {
                       if(showMessage)
                           Icon(androidx.compose.material.icons.Icons.Filled.Warning,"error", tint = MaterialTheme.colors.error)
        },
        singleLine = true,
        isError = showMessage,
        label = { Text("Enter Pokemon name", fontFamily = pokemonFont, color = CeruleanBlue)},
        textStyle = TextStyle(color = Color.Black, fontSize = 16.sp, fontFamily = pokemonFont, letterSpacing = 2.sp)
    )
    if(showMessage || viewModel.pokemonNotExist.value || viewModel.notEnough.value) {
        var errorText = "Error. Try again"
        if (viewModel.pokemonNotExist.value) {
            errorText = "Pokemon doesn't exist. Try another."
        } else if(viewModel.notEnough.value){
            errorText = "You do not have sufficient funds."
        }
        Text(
            text = errorText,
            color = MaterialTheme.colors.error,
            style = MaterialTheme.typography.caption,
            modifier = Modifier.padding(start = 16.dp),
            fontFamily = pokemonFont
        )
    }
}