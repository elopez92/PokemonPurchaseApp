package com.elopez.pokemonpurchaseapp.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elopez.pokemonpurchaseapp.PokemonViewModel
import com.elopez.pokemonpurchaseapp.R
import com.elopez.pokemonpurchaseapp.model.User
import com.elopez.pokemonpurchaseapp.ui.theme.pokemonFont
import com.elopez.pokemonpurchaseapp.utils.loadPicture
import java.text.DecimalFormat

@Composable
fun PurchaseSummaryScreen(
    viewModel: PokemonViewModel,
    modifier: Modifier = Modifier
) {
    val df = DecimalFormat("#.##")
    val price = (viewModel.pokemonResponse.base_experience * .01) * 6
    val sPrice = df.format(price)
    val balance = df.format(viewModel.user.balance)
    val remainingBalance = df.format(viewModel.user.balance - price)
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = modifier
                .padding(16.dp)
        ) {
            Text(
                text = "${viewModel.pokemonResponse.name?.capitalize() ?: ""} #${viewModel.pokemonResponse.id ?: ""}",
                textAlign = TextAlign.Center,
                modifier = modifier.fillMaxWidth(),
                fontSize = 20.sp,
                letterSpacing = 2.sp
            )
            val image = viewModel.pokemonResponse.sprites?.front_default?.let {
                loadPicture(url = it, defaultImage = R.drawable.pokemon_title).value
            }
            image?.let { img ->
                Image(
                    bitmap = img.asImageBitmap(),
                    contentDescription = viewModel.pokemonResponse.name,
                    modifier = modifier
                        .height(90.dp)
                        .align(Alignment.CenterHorizontally),
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.Center,
                )
            }
            fullWidthTextComposable(text1 = "Current balance", text2 = "$$balance")
            fullWidthTextComposable(text1 = "Cost", text2 = "$$sPrice")
            fullWidthTextComposable(
                text1 = "Remaining balance",
                text2 = "$$remainingBalance"
            )
        }
        Button(
            onClick = {},
            modifier = modifier
                .padding(16.dp)
                .align(Alignment.BottomCenter)
                .padding(16.dp),
        ) {
            Text("Complete Purchase", color = Color.White, fontFamily = pokemonFont)
        }
    }
}

@Composable
fun fullWidthTextComposable(text1: String, text2: Any){
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween){
        Text(text = text1, modifier = Modifier.weight(3f))
        Text(text = text2.toString(), textAlign = TextAlign.End, modifier = Modifier.padding(16.dp, 8.dp, 0.dp, 0.dp).weight(1f))
    }
}