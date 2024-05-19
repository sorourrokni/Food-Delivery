package com.example.fooddelivery.data

import androidx.annotation.DrawableRes

data class Payment(
    val foods_list:LinkedHashMap<Food,Int> ,
    val total_price: Int,
    val address:Address,
    val delivery: Delivery,
    val payment_method:payment_method
)
