package com.example.fooddelivery.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import com.example.fooddelivery.ui.profile.edit.EditProfileScreen

@Composable
fun NavigationGraph(navController: NavHostController, fakeData: FakeData, modifier: Modifier) {

    val navControllerWithHistory = remember { NavControllerWithHistory(navController) }

    NavHost(
        navController = navControllerWithHistory.navController,
        startDestination = NavigationItem.Home.route,
        modifier = modifier
    ) {

        composable(NavigationItem.Home.route) {
            HomeScreen(navControllerWithHistory = navControllerWithHistory)
        }
        composable(NavigationItem.Profile.route) {
            ProfileScreen(
                person = fakeData.person1,
                address = fakeData.address1,
                name = "profile",
                navControllerWithHistory = navControllerWithHistory
            )
        }
        composable(NavigationItem.Favorite.route) {
            FavoriteScreen(foodList = fakeData.foods)
        }
        composable(NavigationItem.History.route) {
            HistoryScreen(payments = fakeData.payments)
        }
        composable(Screen.FoodDetail.route) {
            FoodDetailScreen(
                name = "foodDetail",
                navControllerWithHistory = navControllerWithHistory
            )
        }
        composable(Screen.Expandable.route) {
            ExpandableHomeScreen(
                name = "expandable",
                navControllerWithHistory = navControllerWithHistory
            )
        }
        composable(Screen.Home.route) {
            HomeScreen(navControllerWithHistory = navControllerWithHistory)
        }
        composable(Screen.EditProfile.route) {
            EditProfileScreen(
                person = fakeData.person1,
                address = fakeData.address1,
                navControllerWithHistory = navControllerWithHistory
            )
        }
    }
}
