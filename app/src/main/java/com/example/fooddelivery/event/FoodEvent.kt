package com.example.fooddelivery.event

sealed interface FoodEvent {
    object SaveFood: FoodEvent  // singleton
    data class SetName(val name: String): FoodEvent
    data class SetDescription(val description: String): FoodEvent
    data class SetPrice(val price: String): FoodEvent
    data class SetImageResId(val imageResId: Int): FoodEvent



}