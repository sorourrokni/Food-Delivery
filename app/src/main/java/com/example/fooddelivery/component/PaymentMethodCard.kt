package com.example.fooddelivery.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.fooddelivery.R
import com.example.fooddelivery.data.Delivery
import com.example.fooddelivery.data.Payment
import com.example.fooddelivery.data.payment_method

@Composable
fun  PaymentMethodCard(modifier:Modifier=Modifier) {
    val selectedOption = remember { mutableStateOf(payment_method.Card) }
    Text(text = "Payment method",style= MaterialTheme.typography.titleSmall, modifier =Modifier.padding(start=50.dp,end=46.dp,top=42.dp, bottom = 20.dp))
    Column(modifier.background(Color.White, RoundedCornerShape(20.dp))){
        Spacer(Modifier.height(20.dp))

        Column(){
            Row(Modifier.padding(start=25.dp)){
                RadioButton(selected = selectedOption.value== payment_method.Card,
                    onClick = {selectedOption.value= payment_method.Card})
                Column(horizontalAlignment = Alignment.CenterHorizontally){
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(modifier= Modifier
                        .background(MaterialTheme.colorScheme.onError, RoundedCornerShape(10.dp))
                        .size(40.dp, 40.dp), horizontalArrangement = Arrangement.Center){
                    Image(painter = painterResource(id = R.drawable.bi_credit_card_2_front_fill), contentDescription = null,modifier=Modifier.padding(top=11.dp))
                }}

                Text("Card", style = MaterialTheme.typography.bodyMedium,modifier=Modifier.padding(top=12.dp,start=16.dp))
            }
            Divider(color = Color.Black, thickness = 0.5.dp, modifier = Modifier.padding(start = 51.dp,end=32.dp,top=12.dp))

            Row(Modifier.padding(start=25.dp, bottom = 20.dp,top=12.dp)){
                RadioButton(selected = selectedOption.value== payment_method.Direct_pay,
                    onClick = {selectedOption.value= payment_method.Direct_pay})
                Column(horizontalAlignment = Alignment.CenterHorizontally){
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(modifier= Modifier
                        .background(Color(0xffEB4796), RoundedCornerShape(10.dp))
                        .size(40.dp, 40.dp), horizontalArrangement = Arrangement.Center){
                    Image(painter = painterResource(id = R.drawable.coin), contentDescription = null,modifier=Modifier.padding(top=10.dp))}
                }
                Text("Direct Pay", style = MaterialTheme.typography.bodyMedium,modifier=Modifier.padding(top=12.dp,start=16.dp))
            }


        }
    }
}