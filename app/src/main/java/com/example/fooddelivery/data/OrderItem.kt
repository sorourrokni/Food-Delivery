package com.example.fooddelivery.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(foreignKeys = [ForeignKey(
    entity = Order::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("orderID"),
    onDelete = ForeignKey.CASCADE
),
    ForeignKey(
        entity = Food::class,
        parentColumns = arrayOf("name"),
        childColumns = arrayOf("foodID"),
        onDelete = ForeignKey.CASCADE
    )]
,
    primaryKeys = ["orderID","foodID"])

data class OrderItem (
    var quantity:Int,
    @ColumnInfo(index = true)
    val orderID:Int,
    @ColumnInfo(index = true)
    val foodID:String

)

