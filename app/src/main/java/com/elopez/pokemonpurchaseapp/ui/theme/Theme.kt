package com.elopez.pokemonpurchaseapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = CeruleanBlue,
    primaryVariant = GoldFoil,
    secondary = GoldenYellow,
    error = Red,
    background = BostonUniversityRed,
    surface = BostonUniversityRed
)

private val LightColorPalette = lightColors(
    primary = CeruleanBlue,
    primaryVariant = GoldFoil,
    secondary = GoldenYellow,
    background = BostonUniversityRed,
    surface = BostonUniversityRed

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun PokemonPurchaseAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}