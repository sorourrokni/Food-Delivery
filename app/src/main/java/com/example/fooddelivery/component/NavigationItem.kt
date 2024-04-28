package com.example.fooddelivery.component

import com.example.fooddelivery.R

sealed class NavigationItem(var route: String, var selectedIcon: Int, var unSelectedIcon: Int) {
    data object Home :
        NavigationItem("home", R.drawable.ic_home_selected, R.drawable.ic_home_unselected)

    data object Profile :
        NavigationItem("profile", R.drawable.ic_user_selected, R.drawable.ic_user_unselected)

    data object Favorite :
        NavigationItem("favorite", R.drawable.ic_heart_selected, R.drawable.ic_heart_unselected)

    data object History : NavigationItem(
        "history",
        R.drawable.ic_stickynote_selected,
        R.drawable.ic_stickynote_unselected
    )

}
