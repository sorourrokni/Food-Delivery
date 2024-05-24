package com.example.fooddelivery.navigation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object FoodDetail : Screen("foodDetail")
    data object EditProfile : Screen("editProfile")
    data object Expandable : Screen("expandable")
    data object ForgotPass: Screen("forgotPass")
    data object Verification: Screen("verification")
    data object ConnectionLoss: Screen("connectionLoss")

    data object AuthLayout: Screen("AuthLayout")



}