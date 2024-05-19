package com.example.fooddelivery.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(foreignKeys = [ForeignKey(
    entity = Person::class,
    parentColumns = arrayOf("email"),
    childColumns = arrayOf("Email"),
    onDelete = ForeignKey.CASCADE
),
    ForeignKey(
        entity = Food::class,
        parentColumns = arrayOf("name"),
        childColumns = arrayOf("name"),
        onDelete = ForeignKey.CASCADE
    )])
data class foodFav(
    @ColumnInfo(index = true)
    val name:String,
    @ColumnInfo(index = true)
    val Email:String
)