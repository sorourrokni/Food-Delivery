package com.example.fooddelivery.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddelivery.data.Payment
import com.example.fooddelivery.theme.RobotoFontFamily

@Composable
fun HistoryItem(payment: Payment, modifier:Modifier= Modifier){

    Column (modifier= Modifier
        .size(314.dp,134.dp)
        .background(color = MaterialTheme.colorScheme.onPrimary, shape = RoundedCornerShape(20.dp))
        .padding(start = 12.dp, end = 12.dp, bottom = 12.dp, top = 12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding( end = 5.dp)

            , horizontalArrangement = Arrangement.SpaceBetween
        ) {
            HistoryFood(number = payment.foodsList.toList()[0].second, food = payment.foodsList.toList()[0].first)
            Row(modifier= Modifier
                .size(45.dp, 12.dp)
                .background(
                    color = Color(0xB255AC53),
                    shape = RoundedCornerShape(30.dp)
                )
                .align(Alignment.CenterVertically)
                .wrapContentSize(Alignment.Center)
            ){
                Text(text = "Delivered",
                    textAlign = TextAlign.Center,
                    color=Color.White,
                    style = TextStyle(fontWeight = FontWeight(700), fontFamily = RobotoFontFamily
                        , fontSize = 6.sp, lineHeight = 7.sp)


                )
            }
        }
        val it=payment.foodsList.iterator()
        val first_food=payment.foodsList.toList()[0].first.name.toString()

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
                fontSize =6.sp, lineHeight = 7.sp

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
                val first=payment.person.fullName.split(" ")[0].toString()
                val last=payment.person.fullName.split(" ")[1].toString()
                val phone_number=payment.person.phoneNumber.toString()
                val address=payment.address.address.toString()

                Row(modifier= Modifier
                ){
                    Text(text="$first  $last "
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.labelMedium
                        , fontSize = 6.sp
                        , lineHeight = 7.sp
                    )
                }
                Text(text="|"
                    ,modifier=Modifier
                    ,style=MaterialTheme.typography.labelMedium
                    , fontSize = 6.sp
                    , lineHeight = 7.sp)
                Row(modifier= Modifier){
                    Text(text=" $phone_number  "
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.labelMedium
                        , fontSize = 6.sp
                        , lineHeight = 7.sp
                    )
                }
                Text(text="|"
                    ,modifier=Modifier
                    ,style=MaterialTheme.typography.labelMedium
                    , fontSize = 6.sp
                    , lineHeight = 7.sp)
                Row(modifier= Modifier.wrapContentSize(Alignment.Center)
                ){
                    Text(text="   $address"
                        ,modifier=Modifier.wrapContentSize(Alignment.Center)

                        ,style=MaterialTheme.typography.labelMedium
                        , fontSize = 6.sp
                        , lineHeight = 7.sp
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
                fontSize =6.sp, lineHeight = 7.sp

            )
            Row(modifier= Modifier
                .background(
                    MaterialTheme.colorScheme.secondaryContainer,
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(start = 15.dp, top = 5.dp, bottom = 5.dp, end = 5.dp)
            )
            {
                if(payment.paymentMethod.name=="Card"){
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
                        ,style=MaterialTheme.typography.labelMedium
                        , fontSize = 6.sp, lineHeight = 7.sp
                    )
                    Text(text=" | "
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.bodySmall
                        , fontSize = 8.sp)
                    Text(text="Direct pay"
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.displayMedium
                        ,color=MaterialTheme.colorScheme.primary
                        , fontSize = 6.sp, lineHeight = 7.sp
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
                fontSize =6.sp, lineHeight = 7.sp

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
                        ,style=MaterialTheme.typography.displaySmall
                        ,color=MaterialTheme.colorScheme.primary
                        , fontSize = 6.sp, lineHeight = 7.sp

                    )
                    Text(text=" | "
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.labelMedium
                        , fontSize = 6.sp, lineHeight = 7.sp)
                    Text(text="Door Delivery"
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.labelMedium
                        , fontSize = 6.sp, lineHeight = 7.sp
                    )
                }
                else{
                    Text(text="Pick UP  "
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.labelMedium
                        , fontSize = 6.sp, lineHeight = 7.sp
                    )
                    Text(text=" | "
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.labelMedium
                        , fontSize = 6.sp, lineHeight = 7.sp)
                    Text(text="Door Delivery"
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.displaySmall
                        ,color=MaterialTheme.colorScheme.primary
                        , fontSize = 6.sp, lineHeight = 7.sp
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
                    , style = MaterialTheme.typography.titleLarge,
                    color = Color.Black
                    ,fontSize =8.sp, lineHeight = 9.sp)
                val tot_price=payment.totalPrice
                Text(text="#$tot_price"
                    ,modifier= Modifier
                        .padding(start=9.dp,top=5.dp)
                    ,
                    color = MaterialTheme.colorScheme.primary
                    , style = MaterialTheme.typography.titleLarge,
                    fontSize =8.sp, lineHeight = 9.sp)
            }
        }
    }
}


