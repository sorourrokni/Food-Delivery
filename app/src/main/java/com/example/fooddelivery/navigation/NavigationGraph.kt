package com.example.fooddelivery.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.fooddelivery.ui.home.HomeScreen
import com.example.fooddelivery.ui.home.expandable.ExpandableHomeScreen
import com.example.fooddelivery.ui.home.favorite.FavoriteScreen
import com.example.fooddelivery.ui.home.fooddetail.FoodDetailScreen
import com.example.fooddelivery.ui.home.history.HistoryScreen
import com.example.fooddelivery.ui.profile.ProfileScreen

@Composable
fun NavigationGraph(navController: NavHostController, fakeData: FakeData, modifier: Modifier) {

    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) { HomeScreen(navController = navController) }
        composable(NavigationItem.Profile.route) {
            ProfileScreen(
                person = fakeData.person1,
                address = fakeData.address1,
                name = "profile"
            )
        }
        composable(NavigationItem.Favorite.route) { FavoriteScreen(foodList = fakeData.foods) }
        composable(NavigationItem.History.route) { HistoryScreen(payments = fakeData.payments) }
        composable(Screen.FoodDetail.route) {
            FoodDetailScreen(
                "foodDetail",
                navController = navController
            )
        }
        composable(Screen.Expandable.route) {
            ExpandableHomeScreen(
                name = "expandable",
                navController = navController
            )
        }
        composable(Screen.Home.route) { HomeScreen(navController = navController) }
    }
}
