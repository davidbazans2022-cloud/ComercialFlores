    package com.example.comercialflores.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

    private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,



    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),


)
    private val EsquemaColores = lightColorScheme(
        primary = VerdeOliva,
        onPrimary = Crema,
        primaryContainer = CremaOscuro,
        onPrimaryContainer = TextoOscuro,
        background = Crema,
        onBackground = TextoOscuro,
        surface = Crema,
        onSurface = TextoOscuro
    )





@Composable
fun ComercialFloresTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = EsquemaColores,
        typography = Typography,
        content = content
    )



}

    object AppTheme {
        val spacing: AppSpacing
            @Composable @ReadOnlyComposable get() = LocalAppSpacing.current

        val sizes: AppComponentSizes
            @Composable @ReadOnlyComposable get() = LocalAppComponentSizes.current
    }