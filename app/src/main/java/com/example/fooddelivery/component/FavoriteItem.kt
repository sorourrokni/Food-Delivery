package com.example.fooddelivery.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.fooddelivery.R
import com.example.fooddelivery.data.Food

@Composable
fun FavoriteItem(food : Food,modifier:Modifier=Modifier){
    Row(modifier=Modifier.padding(start = 50.dp,end=50.dp).background(color=Color.White,shape= RoundedCornerShape(10.dp))){
        Image(painter = painterResource(id = food.imageResId), contentDescription = null)
        Column(modifier=Modifier){
            Text(text="${food.name}",
                style=MaterialTheme.typography.titleSmall
            ,color= Color.Black)
            Text(text="# ${food.price}",style=MaterialTheme.typography.titleSmall
            , color = Color(0xFFFA4A0C))
        }
        Image(painter = painterResource(id = R.drawable.ic_heart_selected), contentDescription =null,modifier= Modifier
            .padding(top=20.dp))
    }

}