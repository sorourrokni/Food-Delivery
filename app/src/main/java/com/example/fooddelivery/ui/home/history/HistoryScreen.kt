package com.example.fooddelivery.ui.home.history

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fooddelivery.R
import com.example.fooddelivery.component.HistoryItem
import com.example.fooddelivery.data.Payment

@androidx.compose.runtime.Composable
fun HistoryPage(payments:ArrayList<Payment>, modifier: Modifier = Modifier){
    var enabled by remember { mutableStateOf(true)}
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .verticalScroll(scrollState)

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
                contentDescription = null
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
                text = "History", style = MaterialTheme.typography.displayLarge
            )
        }
        if (payments.size<1){
            Row(modifier= Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
                .padding(top = 20.dp)
            ){
                Image(painter = painterResource(id = R.drawable.empty_history), contentDescription = null,
                    modifier= Modifier.size(width=100.dp,height=100.dp))
            }
            Row(modifier= Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
                .padding(top = 10.dp)){
                Text(text="No history yet",
                    style=MaterialTheme.typography.bodyLarge, color = Color.Black)
            }
            Row(modifier= Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
                .padding(top = 10.dp)){
                Text(text="Hit the orange button down\n"+
                        "\tbelow to Create an order",
                    style=MaterialTheme.typography.bodyMedium,color=Color.Gray)
            }
        }else {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(134.dp)
                    .padding(start = 54.dp, top = 0.dp, end = 41.dp, bottom = 0.dp)
            ) {
                val it = payments.iterator()
                for (e in it) {
                    HistoryItem(e)

                }

            }
        }
    }


}