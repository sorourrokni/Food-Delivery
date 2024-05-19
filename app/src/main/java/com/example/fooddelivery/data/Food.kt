package com.example.fooddelivery.data

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Food(
    @PrimaryKey
    @ColumnInfo(name = "name")val name: String
    ,@ColumnInfo(name = "description")val description:String
    , @ColumnInfo(name = "price")val price: String
    , @ColumnInfo(name = "picture ")@DrawableRes val imageResId: Int)
