package com.example.fooddelivery.navigation

import com.example.fooddelivery.R

sealed class NavigationItem(var route: String, var selectedIcon: Int, var unSelectedIcon: Int) {
    data object Home :
        NavigationItem(
            route = "home",
            selectedIcon = R.drawable.ic_home_selected,
            unSelectedIcon = R.drawable.ic_home_unselected
        )

    data object Profile :
        NavigationItem(
            route = "profile",
            selectedIcon = R.drawable.ic_user_selected,
            unSelectedIcon = R.drawable.ic_user_unselected
        )

    data object Favorite :
        NavigationItem(
            route = "favorite",
            selectedIcon = R.drawable.ic_heart_selected,
            unSelectedIcon = R.drawable.ic_heart_unselected
        )

    data object History : NavigationItem(
        route = "history",
        selectedIcon = R.drawable.ic_stickynote_selected,
        unSelectedIcon = R.drawable.ic_stickynote_unselected
    )

}
