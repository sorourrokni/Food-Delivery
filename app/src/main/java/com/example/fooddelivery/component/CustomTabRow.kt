package com.example.fooddelivery.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp

@Composable
fun CustomTabRow(name: String, modifier: Modifier = Modifier) {
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
            containerColor = MaterialTheme.colorScheme.background,
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
            0 -> TabContent("Content for Foods")
            1 -> TabContent("Content for Drinks")
            2 -> TabContent("Content for Snacks")
            3 -> TabContent("Content for Sauce")
        }
    }
}

@Composable
fun TabContent(content: String) {
    Text(
        text = content,
        style = MaterialTheme.typography.bodyMedium,
        modifier = Modifier.padding(16.dp)
    )
}
