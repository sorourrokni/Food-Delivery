package com.example.fooddelivery.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
    (foreignKeys = [ForeignKey(
    entity = Person::class,
    parentColumns = arrayOf("email"),
    childColumns = arrayOf("userID"),
    onDelete = ForeignKey.CASCADE
),
    ForeignKey(
        entity = Address::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("addressID"),
        onDelete = ForeignKey.CASCADE
    )])
data class Order (
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    var totalPrice:Int,
    val paymentMethod:payment_method,
    val deliveryMethod: Delivery,
    @ColumnInfo(index = true)
    val addressID:Int,
    @ColumnInfo(index = true)
    val userID :String,
    val status: orderStatus

)
