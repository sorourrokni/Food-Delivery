package com.example.fooddelivery.repository

import androidx.annotation.WorkerThread
import com.example.fooddelivery.data.Order
import com.example.fooddelivery.data.OrderItem
import com.example.fooddelivery.data.Person
import com.example.fooddelivery.data.dao.OrderDao
import kotlinx.coroutines.flow.Flow

class OrderRepository(private val orderDao: OrderDao,email:String,addressID:Int,orderID:Int) {
    val allUserOrders: Flow<List<Order>> = orderDao.getAllOrdersByUser(email)
    val allOrders: Flow<List<Order>> = orderDao.getAllOrders()
    val allTODOOrders: Flow<List<Order>> = orderDao.getUserTODOCart(email)
    val allUserHistory: Flow<List<Order>> = orderDao.getUserHistory(email)
    val allOrdersById: Flow<List<Order>> = orderDao.getOrderAddressByID(addressID)
    val allOrderItemsById: Flow<List<OrderItem>> = orderDao.getOrderItemsByID(orderID)






    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun upsert(order: Order) {
        orderDao.upsertOrder(order = order)
    }

}