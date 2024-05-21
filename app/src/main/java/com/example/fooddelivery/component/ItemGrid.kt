package com.example.fooddelivery.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.fooddelivery.R
import com.example.fooddelivery.data.Food

@Composable
fun ItemGrid(navController: NavHostController) {

    val foodItems = listOf(
        Food("Veggie tomato mix", "N1,900", 100, R.drawable.food_1),
        Food("Egg and cucumber", "N1,900", 200, R.drawable.food_2),
        Food("Egg and cucumber", "N1,900", 250, R.drawable.food_3),
        Food("Egg and cucumber", "N1,900", 480, R.drawable.food_4),
        Food("Egg and cucumber", "N1,900", 100, R.drawable.food_1),
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp, 16.dp),
        modifier = Modifier
            .background(
                color = MaterialTheme.colorScheme.onSecondary,
                shape = RoundedCornerShape(30.dp)
            )
            .padding(top = 36.dp)

    ) {
        items(foodItems.size) { index ->
            val topPadding = if (index % 2 == 0) 0.dp else 54.dp
            Box(
                modifier = Modifier
                    .padding(top = topPadding)
            ) {
                FoodItem(
                    foodItem = foodItems[index],
                    width = 156,
                    topHeight = 252,
                    height = 212,
                    titlePadding = 8,
                    imgPadding = 0,
                    scale = 1.2f,
                   navController = navController
                )
            }
        }
    }
}
