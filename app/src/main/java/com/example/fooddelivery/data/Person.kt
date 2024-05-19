package com.example.fooddelivery.data

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Person (
    @PrimaryKey
    val email:String,
    val phoneNumber:String,
    val fullName:String,
    val password:String,
    @DrawableRes val profileImg: Int
)