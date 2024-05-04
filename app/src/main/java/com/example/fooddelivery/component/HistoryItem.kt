package com.example.fooddelivery.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddelivery.R
import com.example.fooddelivery.data.Food
import com.example.fooddelivery.data.Payment
import java.security.KeyStore
import java.security.KeyStore.Entry
import java.util.Map

@Composable
fun HistoryItem(payment: Payment, modifier:Modifier= Modifier){
    val scrollState = rememberScrollState()

    Column (modifier= Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colorScheme.onPrimary, shape = RoundedCornerShape(20.dp))
        .verticalScroll(scrollState)
        .padding(start = 10.dp, end = 10.dp, bottom = 10.dp, top = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding( end = 5.dp)
            , horizontalArrangement = Arrangement.SpaceBetween
        ) {
            HistoryFood(number = payment.foods_list.toList()[0].second, food = payment.foods_list.toList()[0].first)
            Row(modifier= Modifier
                .size(50.dp, 24.dp)
                .background(
                    color = MaterialTheme.colorScheme.error,
                    shape = RoundedCornerShape(30.dp)
                )
                .align(Alignment.CenterVertically)
                .wrapContentSize(Alignment.Center)
            ){
                Text(text = "Delivered",textAlign = TextAlign.Center, style = MaterialTheme.typography.bodySmall, fontSize =8.sp
                )
            }
        }
        val it=payment.foods_list.iterator()
        val first_food=payment.foods_list.toList()[0].first.name.toString()
        for (e in it){
            if(e.key.name==first_food){
                null
            }
            else{
                HistoryFood(number = e.value, food = e.key)
            }}
        Row (modifier= Modifier
            .padding(start = 5.dp, bottom = 8.dp)
            .wrapContentSize(Alignment.Center)
            , horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Address Details",
                modifier= Modifier
                    .padding(top = 5.dp, end = 10.dp)
                    .size(height = 15.dp, width = 80.dp),
                style=MaterialTheme.typography.bodyMedium,
                fontSize =10.sp

            )
            Row(modifier= Modifier
                .fillMaxWidth()
                .background(
                    MaterialTheme.colorScheme.secondaryContainer,
                    shape = RoundedCornerShape(20.dp)
                )

                .padding(start = 15.dp, top = 5.dp, bottom = 5.dp, end = 5.dp)

            )
            {
                val first=payment.address.first_name.toString()
                val last=payment.address.last_name.toString()
                val phone_number=payment.address.phone_number.toString()
                val address=payment.address.address.toString()

                Row(modifier= Modifier
                ){
                    Text(text="$first  $last "
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.bodySmall
                        , fontSize = 6.sp
                    )
                }
                Text(text="|"
                    ,modifier=Modifier
                    ,style=MaterialTheme.typography.bodySmall
                    , fontSize = 8.sp)
                Row(modifier= Modifier){
                    Text(text=" $phone_number  "
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.bodySmall
                        , fontSize = 6.sp
                    )
                }
                Text(text="|"
                    ,modifier=Modifier
                    ,style=MaterialTheme.typography.bodySmall
                    , fontSize = 8.sp)
                Row(modifier= Modifier.wrapContentSize(Alignment.Center)
                ){
                    Text(text="   $address"
                        ,modifier=Modifier.wrapContentSize(Alignment.Center)

                        ,style=MaterialTheme.typography.bodySmall
                        , fontSize = 6.sp
                    )
                }

            }


        }
        Row (modifier= Modifier
            .padding(start = 5.dp, bottom = 8.dp)
            .wrapContentSize(Alignment.Center)

            , horizontalArrangement = Arrangement.SpaceBetween){

            Text(text = "Payment",
                modifier= Modifier
                    .padding(top = 5.dp, end = 10.dp)
                    .size(height = 15.dp, width = 80.dp),
                style=MaterialTheme.typography.bodyMedium,
                fontSize =10.sp

            )
            Row(modifier= Modifier
                .background(
                    MaterialTheme.colorScheme.secondaryContainer,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(start = 15.dp, top = 5.dp, bottom = 5.dp, end = 5.dp)
            )
            {
                if(payment.payment_method.name=="Card"){
                    Text(text="Card  "
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.bodySmall
                        ,color=MaterialTheme.colorScheme.primary
                        , fontSize = 8.sp
                    )
                    Text(text=" | "
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.bodySmall
                        , fontSize = 8.sp)
                    Text(text="Direct pay"
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.bodySmall
                        , fontSize = 8.sp
                    )
                }
                else{
                    Text(text="Card  "
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.bodySmall
                        , fontSize = 8.sp
                    )
                    Text(text=" | "
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.bodySmall
                        , fontSize = 8.sp)
                    Text(text="Direct pay"
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.bodySmall
                        ,color=MaterialTheme.colorScheme.primary
                        , fontSize = 8.sp
                    )
                }

            }
        }
        Row (modifier= Modifier
            .padding(start = 5.dp)
            .wrapContentSize(Alignment.Center)

            , horizontalArrangement = Arrangement.SpaceBetween){

            Text(text = "Delivery",
                modifier= Modifier
                    .padding(top = 5.dp, end = 10.dp)
                    .size(height = 15.dp, width = 80.dp),
                style=MaterialTheme.typography.bodyMedium,
                fontSize =10.sp

            )
            Row(modifier= Modifier
                .background(
                    MaterialTheme.colorScheme.secondaryContainer,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(start = 15.dp, top = 5.dp, bottom = 5.dp, end = 5.dp)
            )
            {
                if(payment.delivery.name=="PickUp"){
                    Text(text="Pick Up  "
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.bodySmall
                        ,color=MaterialTheme.colorScheme.primary
                        , fontSize = 8.sp
                    )
                    Text(text=" | "
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.bodySmall
                        , fontSize = 8.sp)
                    Text(text="Door Delivery"
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.bodySmall
                        , fontSize = 8.sp
                    )
                }
                else{
                    Text(text="Pick UP  "
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.bodySmall
                        , fontSize = 8.sp
                    )
                    Text(text=" | "
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.bodySmall
                        , fontSize = 8.sp)
                    Text(text="Door Delivery"
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.bodySmall
                        ,color=MaterialTheme.colorScheme.primary
                        , fontSize = 8.sp
                    )
                }

            }
            Row(modifier=Modifier
                .fillMaxWidth()
                ,horizontalArrangement = Arrangement.End
            ){
                Text("Total  "
                    ,modifier= Modifier
                        .padding(start=9.dp,top=5.dp)
                    , style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                    ,fontSize =8.sp)
                val tot_price=payment.total_price
                Text(text="#$tot_price"
                    ,modifier= Modifier
                        .padding(start=9.dp,top=5.dp)
                    , style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                    ,fontSize =8.sp)
            }
        }
    }
}


