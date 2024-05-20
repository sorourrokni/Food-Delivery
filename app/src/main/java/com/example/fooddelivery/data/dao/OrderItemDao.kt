package com.example.fooddelivery.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.fooddelivery.data.Order
import com.example.fooddelivery.data.OrderItem

@Dao
interface OrderItemDao {
    @Upsert
     fun upsertOrderItem(orderItem: OrderItem)
    @Delete
     fun deleteOrderItem(orderItem: OrderItem)
     @Query("select * from orderitem where orderID==:inputOrderID and foodID==:inputFoodID")
     fun getOrderItemWithFoodIDAndOrderID(inputOrderID: Int,inputFoodID:String):OrderItem
}