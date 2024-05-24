package com.example.fooddelivery.navigation

import android.annotation.SuppressLint
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
import com.example.fooddelivery.viewModel.HomeViewModel
import com.example.fooddelivery.viewModel.ProfileViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun HomeNavigationGraph(
    homeViewModel: HomeViewModel,
    profileViewModel: ProfileViewModel,
    navController: NavHostController,
    modifier: Modifier,
    fakeData: FakeData
) {

    val navControllerWithHistory = remember { NavControllerWithHistory(navController) }
    val email = homeViewModel.getEmail()

    NavHost(
        navController = navControllerWithHistory.navController,
        startDestination = NavigationItem.Home.route,
        modifier = modifier
    ) {

        composable(NavigationItem.Home.route) {
            HomeScreen(
                navControllerWithHistory = navControllerWithHistory,
                foodItems = homeViewModel.foods.value
            )
        }
        composable(NavigationItem.Profile.route) {
            ProfileScreen(
                person = profileViewModel.getProfileInfo(email),
                profileViewModel = profileViewModel,
                navControllerWithHistory = navControllerWithHistory
            )
        }
        composable(NavigationItem.Favorite.route) {

            FavoriteScreen(foodList = homeViewModel.getAllUserFavoriteFood(email))
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
                navControllerWithHistory = navControllerWithHistory,
                foodItems = homeViewModel.foods.value
            )
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
