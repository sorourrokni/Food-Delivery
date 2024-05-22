package com.example.fooddelivery.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddelivery.data.Payment
import com.example.fooddelivery.theme.RobotoFontFamily

@Composable
fun HistoryItem(payment: Payment, modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier

            .background(
                color = MaterialTheme.colorScheme.onPrimary,
                shape = RoundedCornerShape(20.dp)
            )
            .padding(start = 12.dp, end = 12.dp, bottom = 12.dp, top = 12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 5.dp), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            HistoryFood(
                number = payment.foodsList.toList()[0].second,
                food = payment.foodsList.toList()[0].first
            )
            Row(
                modifier = Modifier
                    .size(45.dp, 12.dp)
                    .background(
                        color = Color(0xB255AC53),
                        shape = RoundedCornerShape(30.dp)
                    )
                    .align(Alignment.CenterVertically)
                    .wrapContentSize(Alignment.Center)
            ) {
                Text(
                    text = "Delivered",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    style = TextStyle(
                        fontWeight = FontWeight(700),
                        fontFamily = RobotoFontFamily,
                        fontSize = 6.sp,
                        lineHeight = 7.sp
                    )


                )
            }
        }
        val it = payment.foodsList.iterator()
        val firstFood = payment.foodsList.toList()[0].first.name

        for (e in it) {
            if (e.key.name == firstFood) null
            else {
                HistoryFood(number = e.value, food = e.key)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 16.dp, top = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .width(42.dp),
                text = "Address Details",
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 6.sp, lineHeight = 7.sp
            )
            Row(
                modifier = Modifier
                    .background(
                        MaterialTheme.colorScheme.secondaryContainer.copy(0.2f),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 4.dp, bottom = 4.dp, end = 8.dp)
            )
            {
                val first = payment.person.fullName.split(" ")[0]
                val last = payment.person.fullName.split(" ")[1]
                val phoneNumber = payment.person.phoneNumber
                val address = payment.address.address

                Text(
                    text = "$first  $last ",
                    modifier = Modifier,
                    style = MaterialTheme.typography.labelMedium,
                    fontSize = 6.sp,
                    lineHeight = 7.sp
                )
                Text(
                    text = "|",
                    modifier = Modifier,
                    style = MaterialTheme.typography.labelMedium,
                    fontSize = 6.sp,
                    lineHeight = 7.sp
                )
                Text(
                    text = " $phoneNumber  ",
                    modifier = Modifier,
                    style = MaterialTheme.typography.labelMedium,
                    fontSize = 6.sp,
                    lineHeight = 7.sp
                )
                Text(
                    text = "|",
                    modifier = Modifier,
                    style = MaterialTheme.typography.labelMedium,
                    fontSize = 6.sp,
                    lineHeight = 7.sp
                )
                Text(
                    text = "   $address",
                    modifier = Modifier.wrapContentSize(Alignment.Center),
                    style = MaterialTheme.typography.labelMedium,
                    fontSize = 6.sp,
                    lineHeight = 7.sp
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 16.dp, top = 8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .width(42.dp),
                text = "Payment",
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 6.sp, lineHeight = 7.sp
            )
            Row(
                modifier = Modifier
                    .background(
                        MaterialTheme.colorScheme.secondaryContainer.copy(0.2f),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(start = 8.dp, top = 4.dp, bottom = 4.dp, end = 8.dp)
            )
            {
                if (payment.paymentMethod.name == "Card") {
                    Text(
                        text = "Card  ",
                        modifier = Modifier,
                        style = MaterialTheme.typography.displaySmall,
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 6.sp
                    )
                    Text(
                        text = " | ",
                        modifier = Modifier,
                        style = MaterialTheme.typography.labelMedium,
                        fontSize = 6.sp,
                        lineHeight = 7.sp
                    )
                    Text(
                        text = "Direct pay",
                        style = MaterialTheme.typography.labelMedium,
                        textDecoration = TextDecoration.LineThrough,
                        fontSize = 6.sp,
                        lineHeight = 7.sp
                    )
                } else {
                    Text(
                        text = "Card  ",
                        style = MaterialTheme.typography.labelMedium,
                        textDecoration = TextDecoration.LineThrough,
                        fontSize = 6.sp,
                        lineHeight = 7.sp
                    )
                    Text(
                        text = " | ",
                        modifier = Modifier,
                        style = MaterialTheme.typography.labelMedium,
                        fontSize = 6.sp,
                        lineHeight = 7.sp
                    )
                    Text(
                        text = "Direct pay",
                        modifier = Modifier,
                        style = MaterialTheme.typography.displaySmall,
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 6.sp
                    )
                }

            }
        }
        Row(
            modifier = Modifier
                .padding(start = 8.dp, end = 16.dp, top = 8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Delivery",
                modifier = Modifier
                    .padding(end = 8.dp)
                    .width(42.dp),
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 6.sp, lineHeight = 7.sp

            )
            Row(
                modifier = Modifier
                    .background(
                        MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.2f),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(start = 8.dp, top = 4.dp, bottom = 4.dp, end = 8.dp)
            )
            {
                if (payment.delivery.name == "PickUp") {
                    Text(
                        text = "Pick Up  ",
                        modifier = Modifier,
                        style = MaterialTheme.typography.displaySmall,
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 6.sp
                    )
                    Text(
                        text = " | ",
                        modifier = Modifier,
                        style = MaterialTheme.typography.labelMedium,
                        fontSize = 6.sp,
                        lineHeight = 7.sp
                    )
                    Text(
                        text = "Door Delivery",
                        style = MaterialTheme.typography.labelMedium,
                        textDecoration = TextDecoration.LineThrough,
                        fontSize = 6.sp,
                        lineHeight = 7.sp
                    )
                } else {
                    Text(
                        text = "Pick UP  ",
                        style = MaterialTheme.typography.labelMedium,
                        textDecoration = TextDecoration.LineThrough,
                        fontSize = 6.sp,
                        lineHeight = 7.sp
                    )
                    Text(
                        text = " | ",
                        modifier = Modifier,
                        style = MaterialTheme.typography.labelMedium,
                        fontSize = 6.sp,
                        lineHeight = 7.sp
                    )
                    Text(
                        text = "Door Delivery",
                        modifier = Modifier,
                        style = MaterialTheme.typography.displaySmall,
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 6.sp
                    )
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(), horizontalArrangement = Arrangement.End
            ) {
                Text(
                    "Total  ",
                    modifier = Modifier
                        .padding(start = 9.dp, top = 5.dp),
                    style = MaterialTheme.typography.titleLarge,
                    color = Color.Black,
                    fontSize = 8.sp,
                    lineHeight = 9.sp
                )
                Text(
                    text = "#${payment.totalPrice}",
                    modifier = Modifier
                        .padding(start = 9.dp, top = 5.dp),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleLarge,
                    fontSize = 8.sp,
                    lineHeight = 9.sp
                )
            }
        }
    }
}