package com.example.fooddelivery.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.fooddelivery.navigation.NavControllerWithHistory

@Composable
fun CustomTabRow(name: String, modifier: Modifier = Modifier,navControllerWithHistory: NavControllerWithHistory) {
    val tabTitles = listOf("Foods", "Drinks", "Snacks", "Sauce")
    var selectedTabIndex by remember { mutableStateOf(0) }

    Column {
        ScrollableTabRow(
            selectedTabIndex = selectedTabIndex,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                    color = MaterialTheme.colorScheme.primary
                )
            },
            containerColor = MaterialTheme.colorScheme.onSecondary,
            contentColor = MaterialTheme.colorScheme.onBackground,
            divider = {}
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = {
                        Text(
                            text = title,
                            color = if (selectedTabIndex == index) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onTertiaryContainer,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                )
            }
        }

        // Content below the tab row
        when (selectedTabIndex) {
            0 -> ScrollableRowList(navControllerWithHistory)
            1 -> ScrollableRowList(navControllerWithHistory)
            2 -> ScrollableRowList(navControllerWithHistory)
            3 -> ScrollableRowList(navControllerWithHistory)
        }
    }
}
