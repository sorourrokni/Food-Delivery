package com.example.fooddelivery.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity
    (foreignKeys = [ForeignKey(
    entity = Person::class,
    parentColumns = arrayOf("email"),
    childColumns = arrayOf("user"),
    onDelete = ForeignKey.CASCADE
),
    ForeignKey(
        entity = Address::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("delivery_adr"),
        onDelete = ForeignKey.CASCADE
    )])
data class Order (
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val totalPrice:String,
    val PaymentMethod:payment_method,
    val deliveryMethod: Delivery,
    @ColumnInfo(index = true)
    val delivery_adr:Int,
    @ColumnInfo(index = true)
    val user :String

)
