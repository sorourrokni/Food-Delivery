package com.example.fooddelivery.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.fooddelivery.ui.auth.AuthLayout
import com.example.fooddelivery.ui.auth.forgotpassword.ForgotPasswordScreen
import com.example.fooddelivery.ui.auth.lostconnection.LostConnectionScreen
import com.example.fooddelivery.ui.auth.verification.VerificationScreen
import com.example.fooddelivery.ui.home.HomeScreen
import com.example.fooddelivery.ui.home.expandable.ExpandableHomeScreen
import com.example.fooddelivery.ui.home.favorite.FavoriteScreen
import com.example.fooddelivery.ui.home.fooddetail.FoodDetailScreen
import com.example.fooddelivery.ui.home.history.HistoryScreen
import com.example.fooddelivery.ui.profile.ProfileScreen
import com.example.fooddelivery.ui.profile.edit.EditProfileScreen
import com.example.fooddelivery.viewModel.authViewModel


@Composable
fun AuthNavigationGraph(authVM: authViewModel, navController: NavHostController, modifier: Modifier) {

    val navControllerWithHistory = remember { NavControllerWithHistory(navController) }

    NavHost(
        navController = navControllerWithHistory.navController,
        startDestination = AuthNavigationItem.AuthLayout.route,
        modifier = modifier
    ) {

        composable(AuthNavigationItem.AuthLayout.route) {
            AuthLayout(authVM,navControllerWithHistory = navControllerWithHistory)
        }
        composable(AuthNavigationItem.Verification.route) {
            VerificationScreen( authVM,navControllerWithHistory= navControllerWithHistory)
        }
        composable(AuthNavigationItem.ForgotPass.route) {
            ForgotPasswordScreen(authVM,navControllerWithHistory= navControllerWithHistory)
        }
        composable(AuthNavigationItem.ConnectionLoss.route) {
            LostConnectionScreen(navControllerWithHistory= navControllerWithHistory)
        }

    }
}
