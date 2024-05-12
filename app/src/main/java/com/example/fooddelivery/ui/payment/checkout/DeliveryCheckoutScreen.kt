package com.example.fooddelivery.ui.payment.checkout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddelivery.R
import com.example.fooddelivery.component.AddressCard
import com.example.fooddelivery.component.DeliveryMethodCard
import com.example.fooddelivery.data.Address
import com.example.fooddelivery.data.Delivery
import com.example.fooddelivery.data.Payment

@Composable
fun DeliveryCheckoutScreen(address:Address,total:Int, name:String, modifier: Modifier=Modifier){
    Column(){
        Row(modifier=Modifier.padding(start = 40.dp,top=60.dp)){
            Image(painterResource(id = R.drawable.chevron_left),null)
            Text("Checkout",style=MaterialTheme.typography.titleMedium,modifier=Modifier.padding(start=96.dp))
        }
        Row(modifier=Modifier.padding(start=54.dp,top=40.dp)){
            Text("Delivery",style= MaterialTheme.typography.headlineLarge)
        }
        Row(modifier=Modifier.padding(start=40.dp,top=44.dp), horizontalArrangement = Arrangement.SpaceBetween){
            Text("Address details",style=MaterialTheme.typography.headlineSmall.copy(fontSize =18.sp, lineHeight = 21.sp))
            Text("change",style=MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.primary,modifier=Modifier.padding(start = 120.dp))
        }
        AddressCard(address,Modifier.padding(start = 50.dp,end=49.dp))
        DeliveryMethodCard(total = total, modifier = Modifier.padding(start=50.dp,end=46.dp))
        Row(){

        }
    }
}