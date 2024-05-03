package com.example.fooddelivery.ui.home.history

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
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
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(start = 54.dp, top = 0.dp, end = 41.dp, bottom = 0.dp)
            ) {
//                val food_list=LinkedHashMap<Food,Int>()
//                val food=Food("kebab","1N_199",R.drawable.food_1)
//                val food_2=Food("sdf","skldf",R.drawable.food_3)
//                food_list.put(food,3)
//                food_list.put(food_2,120)
//                val payment_methond= payment_method.Card
//                val address=Address("hooman","honarvar","09358340536","iran shiraz adelAbad lsdfjksldf")
//                val payment=Payment(food_list,1000,address,Delivery.PickUp,payment_methond)
                val it=payments.iterator()

                for (e in it) {
                    HistoryItem(e)
                }
            }
        }


}