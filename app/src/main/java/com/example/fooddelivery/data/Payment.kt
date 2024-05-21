package com.example.fooddelivery.data

data class Payment(
    val foodsList: LinkedHashMap<Food, Int>,
    val totalPrice: Int,
    val address: Address,
    val delivery: Delivery,
    val paymentMethod: PaymentMethod,
    val person: Person
)
