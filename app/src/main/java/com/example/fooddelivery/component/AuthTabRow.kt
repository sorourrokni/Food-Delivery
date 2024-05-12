package com.example.fooddelivery.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.fooddelivery.ui.auth.AuthTab

@Composable
fun AuthTabRow(modifier: Modifier = Modifier){
    val tabTitles = AuthTab.entries
    var selectedTabIndex by remember { mutableIntStateOf(0) }

}