package com.example.fooddelivery.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Upsert
import com.example.fooddelivery.data.Order
import com.example.fooddelivery.data.foodFav

@Dao
interface OrderDao {
    @Upsert
    suspend fun upsertOrder(order: Order)
    @Delete
    suspend fun deleteOrder(order: Order)
}