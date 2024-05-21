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
fun FoodItem(
    foodItem: Food,
    width: Int,
    topHeight: Int,
    height: Int,
    scale: Float,
    titlePadding: Int,
    imgPadding: Int
) {
    Box(
        modifier = Modifier
            .padding(start = 17.dp, top = 0.dp, end = 17.dp, bottom = 0.dp)
            .fillMaxSize()
            .height(topHeight.dp)
            .width(width.dp)
            .background(
                color = MaterialTheme.colorScheme.onSecondary,
                shape = RoundedCornerShape(30.dp)
            )
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .height(height.dp)
                .width(width.dp)
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
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 64.dp, start = titlePadding.dp, end = titlePadding.dp)

                )
                Text(
                    text = foodItem.price.toString(),
                    style = MaterialTheme.typography.displaySmall
                        .copy(color = MaterialTheme.colorScheme.primary),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 15.dp, bottom = 39.dp)
                )
            }
        }
        Image(
            painter = painterResource(id = foodItem.imageResId),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .size(164.dp, 164.dp)
                .scale(scale)
                .padding(top = imgPadding.dp)
        )
    }
}
