package com.example.fooddelivery.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.fooddelivery.navigation.BottomNavigationBar
import com.example.fooddelivery.navigation.FakeData
import com.example.fooddelivery.navigation.HomeNavigationGraph
import com.example.fooddelivery.navigation.NavControllerWithHistory
import com.example.fooddelivery.navigation.NavigationItem
import com.example.fooddelivery.viewModel.HomeViewModel
import com.example.fooddelivery.viewModel.ProfileViewModel

@Composable
fun MainScreen(
    homeViewModel: HomeViewModel,
    profileViewModel: ProfileViewModel,
    navControllerWithHistory: NavControllerWithHistory
) {

    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Profile,
        NavigationItem.Favorite,
        NavigationItem.History
    )
    Scaffold(
        bottomBar = { BottomNavigationBar(navControllerWithHistory.navController, items) }
    ) { innerPadding: PaddingValues ->
        HomeNavigationGraph(
            navController = navControllerWithHistory.navController,
            modifier = Modifier.padding(innerPadding),
            homeViewModel = homeViewModel,
            profileViewModel = profileViewModel,
            fakeData = FakeData()
        )
    }
}
