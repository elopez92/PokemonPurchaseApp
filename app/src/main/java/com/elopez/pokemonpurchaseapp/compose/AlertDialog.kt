package com.elopez.pokemonpurchaseapp.compose

import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable

@Composable
fun AppAlertDialog(){
    AlertDialog(
        onDismissRequest = {},
        confirmButton = {
            TextButton(onClick = {}) {
                Text("OK")
            }
        },
        title = {
            Text(text = "Problem")
        },
        text = {
            Text(text = "You do not have sufficient funds.")
        }
    )
}