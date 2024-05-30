package com.example.fooddelivery.repository

import com.example.fooddelivery.data.Delivery
import com.example.fooddelivery.data.Order
import com.example.fooddelivery.data.OrderItem
import com.example.fooddelivery.data.PaymentMethod
import com.example.fooddelivery.data.dao.OrderDao
import com.example.fooddelivery.data.orderStatus
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class OrderRepositoryTest {

    private lateinit var orderRepository: OrderRepository
    private lateinit var orderDao: OrderDao

    @Before
    fun setup() {
        orderDao = mock(OrderDao::class.java)
        orderRepository = OrderRepository(orderDao)
    }

    @Test
    fun testUpsert() = runBlocking {
        val order = Order(
            id = 1,
            totalPrice = 3000,
            paymentMethod = PaymentMethod.Card,
            deliveryMethod = Delivery.PickUp,
            addressID = 1,
            userID = "user@example.com",
            status = orderStatus.DONE)

        orderRepository.upsert(order)

        verify(orderDao).upsertOrder(order)
    }

    @Test
    fun testGetUserHistoryOrder(): Unit = runBlocking {
        val email = "user@example.com"

        orderRepository.getUserHistoryOrder(email)

        verify(orderDao).getUserHistory(email)
    }

    @Test
    fun testGetOrderItemsById(): Unit = runBlocking {
        val orderId = 1

        orderRepository.getOrderItemsById(orderId)

        verify(orderDao).getOrderItemsByID(orderId)
    }


}
