package com.elopez.pokemonpurchaseapp.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elopez.pokemonpurchaseapp.PokemonViewModel
import com.elopez.pokemonpurchaseapp.R
import com.elopez.pokemonpurchaseapp.ui.theme.CeruleanBlue
import com.elopez.pokemonpurchaseapp.ui.theme.GoldenYellow
import com.elopez.pokemonpurchaseapp.ui.theme.pokemonFont
import java.text.DecimalFormat
import java.util.*

@Composable
fun AppAlertDialog(viewModel: PokemonViewModel, modifier: Modifier = Modifier) {
    Card(
        //shape = MaterialTheme.shapes.medium,
        shape = RoundedCornerShape(10.dp),
        // modifier = modifier.size(280.dp, 240.dp)
        modifier = modifier.padding(10.dp, 5.dp, 10.dp, 10.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier
                .background(Color.White)
        ) {

            //.......................................................................
            Image(
                painter = painterResource(id = R.drawable.pok_ball_icon),
                contentDescription = null, // decorative
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .padding(top = 35.dp)
                    .height(70.dp)
                    .fillMaxWidth(),

                )

            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Insufficient funds",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(top = 5.dp, bottom = 20.dp)
                        .fillMaxWidth(),
                    fontSize = 20.sp,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                val cost = (viewModel.pokemonResponse.base_experience * .01) * 6
                val df = DecimalFormat("#.##")
                fullWidthTextComposable(
                    text1 = "${viewModel.pokemonResponse.name?.replaceFirstChar {
                        if (it.isLowerCase()) it.titlecase(
                            Locale.ROOT
                        ) else it.toString()
                    }} cost",
                    text2 = "$${df.format(cost)}"
                )
                fullWidthTextComposable(
                    text1 = "current balance",
                    text2 = "$${df.format(viewModel.user.balance)}"
                )
            }
            //.......................................................................
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .background(GoldenYellow),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                TextButton(onClick = {
                    viewModel.notEnough.value = false
                }) {
                    Text(
                        "Ok",
                        fontWeight = FontWeight.ExtraBold,
                        fontFamily = pokemonFont,
                        fontSize = 18.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                    )
                }
            }
        }
    }
}