package com.example.fooddelivery.data

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.annotation.DrawableRes

data class Person (
    val email:Email,
    val phoneNumber:String,
    val fullName:String,
    val password:String,
    @DrawableRes val profileImg: Int,
    val nationalCode:Int
        )