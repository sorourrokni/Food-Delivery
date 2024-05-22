package com.example.fooddelivery.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.fooddelivery.R
import com.example.fooddelivery.data.Food

@Composable
fun FavoriteItem(food: Food, modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .padding(start = 48.dp, end = 48.dp, bottom = 24.dp)
            .size(width = 315.dp, height = 102.dp)
            .background(
                color = MaterialTheme.colorScheme.onPrimary,
                shape = RoundedCornerShape(20.dp)
            )
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(top = 16.dp), verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = food.imageResId),
                contentDescription = null,
                Modifier
                    .size(100.dp, 100.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(top = 16.dp, end = 16.dp)
        ) {
            Text(
                text = food.name,
                style = MaterialTheme.typography.titleSmall, color = Color.Black
            )
            Text(
                modifier = Modifier.padding(top = 12.dp),
                text = "# ${food.price}",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.primary
            )
        }
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(bottom = 24.dp, end = 24.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_heart_selected),
                contentDescription = null,
                modifier = Modifier

            )
        }

    }

}