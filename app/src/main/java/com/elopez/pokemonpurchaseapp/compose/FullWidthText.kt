package com.elopez.pokemonpurchaseapp.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun fullWidthTextComposable(text1: String, text2: Any){
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween){
        Text(text = text1, modifier = Modifier.weight(4f))
        Text(text = text2.toString(), textAlign = TextAlign.End, modifier = Modifier
            .padding(16.dp, 8.dp, 0.dp, 0.dp)
            .weight(2f))
    }
}