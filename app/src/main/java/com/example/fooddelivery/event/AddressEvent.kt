package com.example.fooddelivery.event

import com.example.fooddelivery.data.Address


sealed interface AddressEvent {

    object SaveAddress: AddressEvent
    data class setAddress(val address:String): AddressEvent
    data class setDescription(val description:String): AddressEvent
    data class setUserEmail(val userEmail:String): AddressEvent

}