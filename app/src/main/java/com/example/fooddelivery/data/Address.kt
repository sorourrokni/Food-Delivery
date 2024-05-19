package com.example.fooddelivery.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(
entity = Person::class,
parentColumns = arrayOf("email"),
childColumns = arrayOf("userId"),
onDelete = ForeignKey.CASCADE
)])
data class Address(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val address:String,
    val description:String,
    @ColumnInfo(index = true)
    val userId:String
)