package com.example.fooddelivery.ui.home

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.fooddelivery.PaymentActivity
import com.example.fooddelivery.R
import com.example.fooddelivery.component.CustomTabRow
import com.example.fooddelivery.data.Food
import com.example.fooddelivery.navigation.NavControllerWithHistory

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navControllerWithHistory: NavControllerWithHistory,
    foodItems: List<Food>
) {
    val mContext = LocalContext.current
    var enabled by remember { mutableStateOf(true) }
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .verticalScroll(scrollState)
            .background(color = MaterialTheme.colorScheme.onSecondary)
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
                .height(132.dp)
                .padding(start = 54.dp, top = 0.dp, end = 41.dp, bottom = 0.dp)
        ) {
            Text(
                text = "Delicious \n" +
                        "food for you", style = MaterialTheme.typography.displayLarge
            )
        }
        CustomTabRow(
            name = "CustomTabRow", modifier = Modifier
                .fillMaxWidth()
                .padding(start = 75.dp, top = 80.dp, end = 0.dp, bottom = 0.dp)
                .height(33.dp), navControllerWithHistory = navControllerWithHistory,
            foodItems = foodItems
        )
    }
}

