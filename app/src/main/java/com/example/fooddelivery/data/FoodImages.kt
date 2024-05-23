package com.example.fooddelivery.data

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(
    entity = Food::class,
    parentColumns = arrayOf("name"),
    childColumns = arrayOf("foodID"),
    onDelete = ForeignKey.CASCADE
)])
data class FoodImages(
    @PrimaryKey
    @DrawableRes val imageResId: Int,
    val foodID: String
)
