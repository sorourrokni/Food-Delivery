package com.example.fooddelivery.component

import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddelivery.data.Food

@Composable
fun HistoryFood(number:Int,food: Food){
    Row(modifier= Modifier
        .background(color = MaterialTheme.colorScheme.onPrimary)
        .padding(start = 5.dp, end = 5.dp, bottom = 5.dp)

    ){
        Text(text=number.toString(),
            modifier= Modifier
                .size(25.dp, 25.dp)
                .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(25.dp))
                .align(Alignment.CenterVertically)
                .wrapContentSize(Alignment.Center)
            , style = MaterialTheme.typography.bodySmall
            ,fontSize =8.sp
            , color = Color.White)

        Text(text=food.name,
            modifier= Modifier
                .padding(start=9.dp,top=5.dp)
            , style = MaterialTheme.typography.bodyMedium
            ,fontSize =8.sp
        )
        val price =food.price
        Text(text="# $price",
            modifier= Modifier
                .padding(start=9.dp,top=5.dp)
            , style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.primary
            ,fontSize =8.sp
        )
    }

}