package com.example.fooddelivery.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.fooddelivery.data.Address

@Composable
fun AddressCard(address:Address,modifier: Modifier) {
    Column(modifier=modifier
        .background(Color.White,shape= RoundedCornerShape(20.dp)).width(315.dp)){
        Column(modifier=Modifier.padding(start=30.dp, bottom = 25.dp,end=53.dp, top = 25.dp)){
            Text("${address.first_name}  ${address.last_name}",style=MaterialTheme.typography.bodyMedium)
            Divider(color = Color.Black, thickness = 0.5.dp, modifier = Modifier.padding(top=8.dp, bottom = 8.dp))
            Text(address.address,style=MaterialTheme.typography.bodyMedium)
            Divider(color = Color.Black, thickness = 0.5.dp, modifier = Modifier.padding(top=8.dp, bottom = 8.dp))
            Text(address.phone_number,style=MaterialTheme.typography.bodyMedium)


        }



    }
}