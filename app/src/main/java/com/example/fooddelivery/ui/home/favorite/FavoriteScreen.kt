package com.example.fooddelivery.ui.home.favorite

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.fooddelivery.PaymentActivity
import com.example.fooddelivery.R
import com.example.fooddelivery.component.FavoriteItem
import com.example.fooddelivery.data.Food
import kotlinx.coroutines.flow.MutableStateFlow

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun FavoriteScreen(foodList: MutableStateFlow<List<Food>>, modifier: Modifier = Modifier) {
    val mContext = LocalContext.current
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier
            .verticalScroll(scrollState)
            .background(color = MaterialTheme.colorScheme.onSecondary)
            .fillMaxHeight()

    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .height(132.dp)
                .padding(start = 54.dp, top = 74.dp, end = 41.dp, bottom = 0.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.ic_more), contentDescription = null)
            Image(
                painter = painterResource(id = R.drawable.ic_shopping_cart),
                contentDescription = null, modifier = Modifier.clickable {
                    mContext.startActivity(
                        Intent(
                            mContext,
                            PaymentActivity::class.java
                        )
                    )
                }
            )
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 54.dp, top = 0.dp, end = 41.dp, bottom = 56.dp)
        ) {
            Text(
                text = "Favorite foods",
                style = MaterialTheme.typography.displayLarge,
                color = Color.Black
            )
        }
        if (foodList.value.isNotEmpty()) {
            val foods = foodList.value
            for (food in foods) {
                FavoriteItem(food)
            }
        } else {
            Column(
                modifier = Modifier.fillMaxHeight(),
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(align = Alignment.Center)
                        .padding(top = 20.dp)
                        .size(width = 100.dp, height = 100.dp),
                    painter = painterResource(id = R.drawable.ic_heart_unselected),
                    contentDescription = null,
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(align = Alignment.Center)
                        .padding(top = 10.dp),
                    text = "No Favorite foods yet",
                    style = MaterialTheme.typography.bodyLarge, color = Color.Black
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(align = Alignment.Center)
                        .padding(top = 10.dp),
                    text = "Hit the orange button down\n" +
                            "below to Create an order",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}