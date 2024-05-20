package com.example.fooddelivery

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fooddelivery.ui.auth.forgotpassword.ForgotPasswordScreen
import com.example.fooddelivery.ui.auth.lostconnection.LostConnectionScreen
import com.example.fooddelivery.ui.home.HomeScreen

@Composable
fun Navigation(){
    val navController= rememberNavController()
    NavHost(navController=navController,startDestination=Screen.ForgotPasswordScreen.route){
        composable(route=Screen.ForgotPasswordScreen.route){
            ForgotPasswordScreen(navController = navController, name = "hello")
        }
        composable(
            route=Screen.LostConnectionScreen.route,
            arguments = listOf(
                navArgument("name"){
                    type= NavType.StringType
                    defaultValue="kir"
                    nullable=true
                }
            )
        ){
            entry->
            entry.arguments?.getString("name")?.let { LostConnectionScreen(name = it) }
        }
    }
}

