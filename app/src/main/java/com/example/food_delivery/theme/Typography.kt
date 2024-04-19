package com.example.fooddelivery.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.example.food_delivery.R

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)
val RobotoFont = GoogleFont(name = "Roboto")

val RobotoFontFamily = FontFamily(
    Font(resId = R.font.roboto_regular),
    Font(resId = R.font.roboto_medium),
    Font(resId = R.font.roboto_light),
    Font(resId = R.font.roboto_bold),
    Font(resId = R.font.roboto_thin),
    Font(googleFont = RobotoFont, fontProvider = provider, weight = FontWeight(700)),
    Font(googleFont = RobotoFont, fontProvider = provider, weight = FontWeight(600)),
    Font(googleFont = RobotoFont, fontProvider = provider, weight = FontWeight(500)),
    Font(googleFont = RobotoFont, fontProvider = provider, weight = FontWeight(400)),
    Font(googleFont = RobotoFont, fontProvider = provider, weight = FontWeight(300)),
)

val Typography = Typography(
    //bold 34
    displayLarge = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight(700),
        fontSize = 34.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    //bold 22
    displayMedium = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight(700),
        fontSize = 22.sp,
        lineHeight = 26.sp,
        letterSpacing = 0.sp
    ),
    //bold 17
    displaySmall = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight(700),
        fontSize = 17.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp

    ),
    //semi bold 34
    headlineLarge = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight(600),
        fontSize = 34.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    //semi bold 28
    headlineMedium = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight(600),
        fontSize = 28.sp,
        lineHeight = 33.sp,
        letterSpacing = 0.sp
    ),
    //semi bold 22
    headlineSmall = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight(600),
        fontSize = 22.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.sp
    ),
    //medium 28
    titleLarge = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight(500),
        fontSize = 28.sp,
        lineHeight = 33.sp,
        letterSpacing = 0.sp
    ),
    //medium 18
    titleMedium = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight(500),
        fontSize = 18.sp,
        lineHeight = 21.sp,
        letterSpacing = 0.sp
    ),
    //medium 17
    titleSmall = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight(500),
        fontSize = 17.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),
    //regular 28
    bodyLarge = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight(400),
        fontSize = 28.sp,
        lineHeight = 33.sp,
        letterSpacing = 0.sp
    ),
    //regular 17
    bodyMedium = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight(400),
        fontSize = 17.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp
    ),
    //regular 15
    bodySmall = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight(400),
        fontSize = 15.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.sp
    ),
    //light 12
    labelLarge = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight(300),
        fontSize = 12.sp,
        lineHeight = 14.sp,
        letterSpacing = 0.sp
    ),
    //light 6
    labelMedium = TextStyle(
        fontFamily = RobotoFontFamily,
        fontWeight = FontWeight(300),
        fontSize = 6.sp,
        lineHeight = 7.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(

    )
)



