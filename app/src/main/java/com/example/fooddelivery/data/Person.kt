package com.example.fooddelivery.data

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Person (
    @PrimaryKey
    var email:String,
    var phoneNumber:String,
    var fullName:String,
    val password:String,
    @DrawableRes val profileImg: Int
)