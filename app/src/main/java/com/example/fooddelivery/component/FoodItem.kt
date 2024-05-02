package com.example.fooddelivery.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.fooddelivery.data.Food

@Composable
fun FoodItem(foodItem: Food) {
    Box(
        modifier = Modifier
            .padding(start = 17.dp, top = 0.dp, end = 17.dp, bottom = 0.dp)
            .fillMaxSize()
            .height(321.dp)
            .width(220.dp)
            .background(
                color = MaterialTheme.colorScheme.onSecondary,
                shape = RoundedCornerShape(30.dp)
            )
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .height(270.dp)
                .width(220.dp)
                .background(
                    color = MaterialTheme.colorScheme.onPrimary,
                    shape = RoundedCornerShape(30.dp)
                )
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = foodItem.name,
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                        .padding(start = 50.dp, top = 64.dp, end = 50.dp, bottom = 0.dp)
                )
                Text(
                    text = foodItem.price,
                    style = MaterialTheme.typography.displaySmall
                        .copy(color = MaterialTheme.colorScheme.primary),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                        .padding(start = 24.dp, top = 15.dp, end = 24.dp, bottom = 39.dp)
                )
            }
        }
        Image(
            painter = painterResource(id = foodItem.imageResId),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .size(164.16.dp, 164.16.dp).scale(1.7f)
                .padding(start = 0.dp, top = 32.dp, end = 0.dp, bottom = 0.dp)
        )
    }
}
