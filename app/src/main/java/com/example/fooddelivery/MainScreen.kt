package com.example.fooddelivery

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.fooddelivery.navigation.BottomNavigationBar
import com.example.fooddelivery.navigation.FakeData
import com.example.fooddelivery.navigation.HomeNavigationGraph
import com.example.fooddelivery.navigation.NavControllerWithHistory
import com.example.fooddelivery.navigation.NavigationItem

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navControllerWithHistory = remember { NavControllerWithHistory(navController) }

    val fakeData = FakeData()

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
            navController,
            fakeData = fakeData,
            modifier = Modifier.padding(innerPadding)
        )
    }
}
