package com.example.fooddelivery

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.fooddelivery.navigation.BottomNavigationBar
import com.example.fooddelivery.navigation.FakeData
import com.example.fooddelivery.navigation.NavigationGraph
import com.example.fooddelivery.navigation.NavigationItem

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val fakeData = FakeData()

    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Profile,
        NavigationItem.Favorite,
        NavigationItem.History
    )
    Scaffold(
        bottomBar = { BottomNavigationBar(navController, items) }
    ) {
        NavigationGraph(navController, fakeData = fakeData)
    }
}
