package com.example.fooddelivery.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
//    primary = Blue80,
//    onPrimary = Blue20,
//    primaryContainer = Blue30,
//    onPrimaryContainer = Blue90,
//    inversePrimary = Blue40,
//    secondary = DarkBlue80,
//    onSecondary = DarkBlue20,
//    secondaryContainer = DarkBlue30,
//    onSecondaryContainer = DarkBlue90,
//    tertiary = Yellow80,
//    onTertiary = Yellow20,
//    tertiaryContainer = Yellow30,
//    onTertiaryContainer = Yellow90,
//    error = Red80,
//    onError = Red20,
//    errorContainer = Red30,
//    onErrorContainer = Red90,
//    background = Grey10,
//    onBackground = Grey90,
//    surface = Grey10,
//    onSurface = Grey80,
//    inverseSurface = Grey90,
//    inverseOnSurface = Grey20,
//    surfaceVariant = BlueGrey30,
//    onSurfaceVariant = BlueGrey80,
//    outline = BlueGrey60
)

private val LightColorScheme = lightColorScheme(
    primary = Orange01,
    onPrimary = White100,
    primaryContainer = Black100,
    onPrimaryContainer = Grey01,
    inversePrimary = Grey02,
    secondary = Grey03,
    onSecondary = Grey04,
    secondaryContainer = Grey05,
    onSecondaryContainer = Grey06,
    tertiary = Grey07,
    onTertiary = Grey08,
    tertiaryContainer = Grey09,
    onTertiaryContainer = Grey10,
    error = Green,
    onError = Orange02,
    errorContainer = Red,
    onErrorContainer = Orange03,
//    background = Grey99,
//    onBackground = Grey10,
//    surface = Grey99,
//    onSurface = Grey10,
//    inverseSurface = Grey20,
//    inverseOnSurface = Grey95,
//    surfaceVariant = BlueGrey90,
//    onSurfaceVariant = BlueGrey30,
//    outline = BlueGrey50
)

@SuppressLint("NewApi")
@Composable
fun FoodDeliveryTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val myColorScheme = when {
        isDarkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = myColorScheme,
        typography = Typography,
        content = content
    )
}