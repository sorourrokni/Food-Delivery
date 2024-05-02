package com.example.fooddelivery.component

import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.text.TextUtils.indexOf
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ParentDataModifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.node.ParentDataModifierNode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.res.ResourcesCompat
import androidx.ui.core.px
import com.example.fooddelivery.R
import com.example.fooddelivery.data.Food
import com.example.fooddelivery.data.Payment
import java.security.KeyStore
import java.security.KeyStore.Entry
import java.util.Map

@Composable
fun HistoryItem(payment:Payment , modifier:Modifier= Modifier){
//    Box(
//        modifier = modifier
//            .padding(start = 17.dp, top = 0.dp, end = 17.dp, bottom = 0.dp)
//            .fillMaxSize()
//            .height(321.dp)
//            .width(220.dp)
//            .background(
//                color = Color.White,
//                shape = RoundedCornerShape(20.dp)
//            )
//    ) {
//        Box(
//            modifier = Modifier
//                .align(Alignment.TopEnd)
//                .height(20.dp)
//                .width(20.dp)
//                .background(
//                    color = Color.White,
//                    shape = RoundedCornerShape(30.dp)
//                )
//        ) {
//            Column(
//                modifier = Modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Center
//            ) {
//                Text(
//                    text = foodItem.name,
//                    style = MaterialTheme.typography.headlineSmall,
//                    textAlign = TextAlign.Center,
//                    modifier = Modifier.fillMaxWidth()
//                        .padding(start = 50.dp, top = 64.dp, end = 50.dp, bottom = 0.dp)
//                )
//                Text(
//                    text = foodItem.price,
//                    style = MaterialTheme.typography.displaySmall
//                        .copy(color = MaterialTheme.colorScheme.primary),
//                    textAlign = TextAlign.Center,
//                    modifier = Modifier.fillMaxWidth()
//                        .padding(start = 24.dp, top = 15.dp, end = 24.dp, bottom = 39.dp)
//                )
//            }
//        }
//        Image(
//            painter = painterResource(id = foodItem.imageResId),
//            contentDescription = null,
//            modifier = Modifier
//                .align(Alignment.TopCenter)
//                .size(164.16.dp, 164.16.dp).scale(1.7f)
//                .padding(start = 0.dp, top = 32.dp, end = 0.dp, bottom = 0.dp)
//        )
//        Column (modifier=Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center){
//            Row ( horizontalArrangement = Arrangement.SpaceBetween,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(132.dp)
//                    .padding(start = 54.dp, top = 0.dp, end = 41.dp, bottom = 0.dp)){
//                Text(text="salam")
//            }
//        }
//            Text(text = "name")
//
//        }
    val scrollState = rememberScrollState()

    Column (modifier= Modifier
        .fillMaxSize()
        .background(color = Color.White, shape = RoundedCornerShape(20.dp))
        .verticalScroll(scrollState)
        .padding(start = 10.dp, end = 10.dp, bottom = 10.dp, top = 10.dp)
        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
                .padding(end = 5.dp, bottom = 5.dp)
                , horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(modifier= Modifier.padding(start=3.dp)

            ){
                Text(text=payment.foods_list.toList()[0].second.toString(),
                    modifier= Modifier
                        .size(25.dp, 25.dp)
                        .background(Color(0xFFFA4A0C), shape = RoundedCornerShape(25.dp))
                        .align(Alignment.CenterVertically)
                        .wrapContentSize(Alignment.Center)
                , style = MaterialTheme.typography.bodySmall
                ,fontSize =8.sp)
                Text(text=payment.foods_list.toList()[0].first.name.toString(),
                    modifier= Modifier
                        .padding(start=9.dp,top=5.dp)
                    , style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                    ,fontSize =8.sp
                )
                val price =payment.foods_list.toList()[0].first.price.toString()
                Text(text="# $price",
                    modifier= Modifier
                        .padding(start=9.dp,top=5.dp)
                    , style = MaterialTheme.typography.bodySmall,
                    color = Color(0xffFA4A0C)
                    ,fontSize =8.sp
                )
            }

            Row(modifier= Modifier
                .size(50.dp, 24.dp)
                .background(color = Color(0xFF55AC53), shape = RoundedCornerShape(30.dp))
                .align(Alignment.CenterVertically)
                .wrapContentSize(Alignment.Center)
                ){
                Text(text = "Delivered",textAlign = TextAlign.Center, style = MaterialTheme.typography.bodySmall, fontSize =8.sp  )
            }
        }
        val it=payment.foods_list.iterator()
        val first_food=payment.foods_list.toList()[0].first.name.toString()
        for (e in it){
            if(e.key.name==first_food){
                null
            }
            else{
            Row ( modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
                .padding(start = 5.dp, end = 5.dp, bottom = 5.dp)

            ){
                Text(text=e.value.toString(),
                    modifier= Modifier
                        .size(25.dp, 25.dp)
                        .background(Color(0xFFFA4A0C), shape = RoundedCornerShape(25.dp))
                        .align(Alignment.CenterVertically)
                        .wrapContentSize(Alignment.Center)
                    , style = MaterialTheme.typography.bodySmall
                ,fontSize =8.sp)
                Text(text=e.key.name.toString(),
                    modifier= Modifier
                        .padding(start=9.dp,top=5.dp)
                    , style = MaterialTheme.typography.bodyMedium,
                    color = Color.Black
                    ,fontSize =8.sp
                )
                val price =e.key.price.toString()
                Text(text="# $price",
                    modifier= Modifier
                        .padding(start=9.dp,top=5.dp)
                    , style = MaterialTheme.typography.bodySmall,
                    color = Color(0xffFA4A0C)
                    ,fontSize =8.sp
                )
            }
        }}
        Row (modifier= Modifier
            .padding(start = 5.dp, bottom = 8.dp)
            .wrapContentSize(Alignment.Center)
            , horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "Address Details",
                modifier= Modifier.padding(top=5.dp, end = 10.dp).size(height=15.dp, width = 80.dp),
                style=MaterialTheme.typography.bodyMedium,
                color=Color.Black,
                fontSize =10.sp

                )
            Row(modifier= Modifier
                .fillMaxWidth()
                .background(Color(0xffADADAF), shape = RoundedCornerShape(20.dp))

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
                        ,color=Color.Black
                        , fontSize = 6.sp
                    )
                }
                Text(text="|"
                    ,modifier=Modifier
                    ,style=MaterialTheme.typography.bodySmall
                    ,color=Color.Black
                    , fontSize = 8.sp)
                Row(modifier= Modifier){
                    Text(text=" $phone_number  "
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.bodySmall
                        ,color=Color.Black
                        , fontSize = 6.sp
                    )
                }
                Text(text="|"
                    ,modifier=Modifier
                    ,style=MaterialTheme.typography.bodySmall
                    ,color=Color.Black
                    , fontSize = 8.sp)
                Row(modifier= Modifier){
                    Text(text="   $address"
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.bodySmall
                        ,color=Color.Black
                        , fontSize = 6.sp
                    )
                }

            }


        }
        Row (modifier= Modifier
            .padding(start = 5.dp,bottom=8.dp)
            .wrapContentSize(Alignment.Center)

            , horizontalArrangement = Arrangement.SpaceBetween){

            Text(text = "Payment",
                modifier= Modifier
                    .padding(top = 5.dp, end = 10.dp)
                    .size(height=15.dp, width = 80.dp),
                style=MaterialTheme.typography.bodyMedium,
                color=Color.Black,
                fontSize =10.sp

            )
            Row(modifier= Modifier
                .background(Color(0xffADADAF), shape = RoundedCornerShape(20.dp))
                .padding(start = 15.dp, top = 5.dp, bottom = 5.dp, end = 5.dp)
            )
            {
                if(payment.payment_method.name=="Card"){
                    Text(text="Card  "
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.bodySmall
                        ,color=Color(0xffFA4A0C)
                        , fontSize = 8.sp
                    )
                    Text(text=" | "
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.bodySmall
                        ,color=Color.Black
                        , fontSize = 8.sp)
                    Text(text="Direct pay"
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.bodySmall
                        ,color=Color.Black
                        , fontSize = 8.sp
                    )
                }
                else{
                    Text(text="Card  "
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.bodySmall
                        ,color=Color.Black
                        , fontSize = 8.sp
                    )
                    Text(text=" | "
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.bodySmall
                        ,color=Color.Black
                        , fontSize = 8.sp)
                    Text(text="Direct pay"
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.bodySmall
                        ,color=Color(0xffFA4A0C)
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
                    .size(height=15.dp, width = 80.dp),
                style=MaterialTheme.typography.bodyMedium,
                color=Color.Black,
                fontSize =10.sp

            )
            Row(modifier= Modifier
                .background(Color(0xffADADAF), shape = RoundedCornerShape(20.dp))
                .padding(start = 15.dp, top = 5.dp, bottom = 5.dp, end = 5.dp)
            )
            {
                if(payment.delivery.name=="PickUp"){
                    Text(text="Pick Up  "
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.bodySmall
                        ,color=Color(0xffFA4A0C)
                        , fontSize = 8.sp
                    )
                    Text(text=" | "
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.bodySmall
                        ,color=Color.Black
                        , fontSize = 8.sp)
                    Text(text="Door Delivery"
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.bodySmall
                        ,color=Color.Black
                        , fontSize = 8.sp
                    )
                }
                else{
                    Text(text="Pick UP  "
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.bodySmall
                        ,color=Color.Black
                        , fontSize = 8.sp
                    )
                    Text(text=" | "
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.bodySmall
                        ,color=Color.Black
                        , fontSize = 8.sp)
                    Text(text="Door Delivery"
                        ,modifier=Modifier
                        ,style=MaterialTheme.typography.bodySmall
                        ,color=Color(0xffFA4A0C)
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
                    color = Color(0xffFA4A0C)
                    ,fontSize =8.sp)
            }
        }
    }
}


