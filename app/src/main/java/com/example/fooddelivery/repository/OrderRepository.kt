package com.example.fooddelivery.repository

import androidx.annotation.WorkerThread
import com.example.fooddelivery.data.Order
import com.example.fooddelivery.data.OrderItem
import com.example.fooddelivery.data.Person
import com.example.fooddelivery.data.dao.OrderDao
import kotlinx.coroutines.flow.Flow

class OrderRepository(private val orderDao: OrderDao) {






    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun upsert(order: Order) {
        orderDao.upsertOrder(order = order)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getUserHistoryOrder(email:String) {
        orderDao.getUserHistory(email)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getOrderItemsById(orderID:Int) {
        orderDao.getOrderItemsByID(orderID)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getTODOOrders(email:String):List<Order> {
        return orderDao.getUserTODOCart(email)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getAllOrders():List<Order>? {
        return orderDao.getAllOrders()
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getAllUserOrders(email:String) {
        orderDao.getAllOrdersByUser(email)
    }
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getOrderById(orderId:Int):Order? {
        return orderDao.getOrderById(orderId)
    }



}