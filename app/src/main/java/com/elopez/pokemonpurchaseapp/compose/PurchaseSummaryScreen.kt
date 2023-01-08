package com.elopez.pokemonpurchaseapp.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import com.elopez.pokemonpurchaseapp.PokemonViewModel
import com.elopez.pokemonpurchaseapp.R
import com.elopez.pokemonpurchaseapp.model.User
import com.elopez.pokemonpurchaseapp.utils.loadPicture

@Composable
fun PurchaseSummaryScreen(
    viewModel: PokemonViewModel,
    modifier: Modifier = Modifier
){
  Column(

  ){
        Text(
            text = "${viewModel.pokemonResponse.name ?: "" } ${viewModel.pokemonResponse.id?: ""}"
        )
      val image = viewModel.pokemonResponse.sprites?.front_default?.let{
          loadPicture(url = it, defaultImage = R.drawable.pokemon_title).value
      }
      image?.let{ img ->
          Image(
              bitmap = img.asImageBitmap(),
              contentDescription = viewModel.pokemonResponse.name,
              modifier = modifier
                  .height(90.dp),
              contentScale = ContentScale.Fit
          )
      }
  }
}