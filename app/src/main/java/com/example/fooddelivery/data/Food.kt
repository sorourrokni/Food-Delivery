package com.example.fooddelivery.data

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Food(
    @PrimaryKey
    val name: String,
    val description:String,
    val price: Int,
    val category: Category,
    @DrawableRes val imageResId: Int
)
