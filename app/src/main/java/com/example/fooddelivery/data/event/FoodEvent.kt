package com.example.fooddelivery.data.event

sealed interface FoodEvent {
    object SaveContact: FoodEvent  // singleton
    data class SetFirstName(val firstName: String): FoodEvent
    data class SetLastName(val lastName: String): FoodEvent
    data class SetPhoneNumber(val phoneNumber: String): FoodEvent

}