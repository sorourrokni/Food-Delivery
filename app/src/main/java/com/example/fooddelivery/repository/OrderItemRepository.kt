package com.example.fooddelivery.repository

import androidx.annotation.WorkerThread
import com.example.fooddelivery.data.OrderItem
import com.example.fooddelivery.data.Person
import com.example.fooddelivery.data.dao.OrderItemDao

class OrderItemRepository(private val orderItemDao: OrderItemDao) {






    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun upsert(orderItem: OrderItem) {
        orderItemDao.upsertOrderItem(orderItem)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(orderItem: OrderItem) {
        orderItemDao.deleteOrderItem(orderItem)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getOrderItem(orderId:Int,FoodId:String):OrderItem? {
        return orderItemDao.getOrderItemWithFoodIDAndOrderID(orderId,FoodId)
    }

}