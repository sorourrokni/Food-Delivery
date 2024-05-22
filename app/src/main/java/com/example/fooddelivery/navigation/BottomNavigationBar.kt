package com.example.fooddelivery.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(navController: NavHostController, items: List<NavigationItem>) {
    BottomNavigation(backgroundColor = MaterialTheme.colorScheme.onSecondary) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                alwaysShowLabel = false,
                icon = {
                    Icon(
                        painter = painterResource(id = if (currentRoute == item.route) item.selectedIcon else item.unSelectedIcon),
                        contentDescription = null,
                        tint = if (currentRoute == item.route) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondaryContainer
                    )
                },
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
            )
        }
    }
}
