package com.example.fooddelivery.data

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(foreignKeys = [ForeignKey(
    entity = Person::class,
    parentColumns = arrayOf("email"),
    childColumns = arrayOf("userID"),
    onDelete = ForeignKey.CASCADE
),
    ForeignKey(
        entity = Food::class,
        parentColumns = arrayOf("name"),
        childColumns = arrayOf("foodID"),
        onDelete = ForeignKey.CASCADE
    )],
    primaryKeys = ["foodID","userID"])
data class FoodFavorite(
    val foodID:String,
    val userID:String
)