package com.example.fooddelivery.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.fooddelivery.data.Delivery

@Composable
fun DeliveryMethodCard (total:Int,modifier: Modifier){
    val selectedOption = remember { mutableStateOf(Delivery.Door_Delivery) }
    Text(text = "Delivery method",style=MaterialTheme.typography.titleSmall, modifier =Modifier.padding(start=50.dp,end=46.dp,top=42.dp, bottom = 20.dp))
    Column(modifier.background(Color.White, RoundedCornerShape(20.dp))){
        Spacer(Modifier.height(20.dp))

        Column(){
            Row(Modifier.padding(start=25.dp)){
                RadioButton(selected = selectedOption.value==Delivery.Door_Delivery,
                    onClick = {selectedOption.value=Delivery.Door_Delivery})
                Text("Door Delivery", style = MaterialTheme.typography.bodyMedium,modifier=Modifier.padding(top=12.dp,start=16.dp))
            }
            Divider(color = Color.Black, thickness = 0.5.dp, modifier = Modifier.padding(start = 51.dp,end=32.dp,top=12.dp))

            Row(Modifier.padding(start=25.dp, bottom = 20.dp,top=12.dp)){
               RadioButton(selected = selectedOption.value==Delivery.PickUp,
                   onClick = {selectedOption.value=Delivery.PickUp})
               Text("Pick Up", style = MaterialTheme.typography.bodyMedium,modifier=Modifier.padding(top=12.dp,start=16.dp))
           }

        }
    }
}