package com.example.fooddelivery.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Upsert
import com.example.fooddelivery.data.Order
import com.example.fooddelivery.data.OrderItem

@Dao
interface OrderItemDao {
    @Upsert
    suspend fun upsertOrderItem(orderItem: OrderItem)
    @Delete
    suspend fun deleteOrderItem(orderItem: OrderItem)
}