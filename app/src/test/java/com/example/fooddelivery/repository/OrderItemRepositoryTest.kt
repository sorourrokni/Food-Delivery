package com.example.fooddelivery.repository

import com.example.fooddelivery.data.OrderItem
import com.example.fooddelivery.data.dao.OrderItemDao
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class OrderItemRepositoryTest {

    private lateinit var orderItemRepository: OrderItemRepository
    private lateinit var orderItemDao: OrderItemDao

    @Before
    fun setup() {
        orderItemDao = mock(OrderItemDao::class.java)
        orderItemRepository = OrderItemRepository(orderItemDao)
    }

    @Test
    fun testUpsert() = runBlocking {
        val orderItem = OrderItem(orderID = 1, foodID = "pizza", quantity = 2)

        orderItemRepository.upsert(orderItem)

        verify(orderItemDao).upsertOrderItem(orderItem)
    }

    @Test
    fun testDelete() = runBlocking {
        val orderItem = OrderItem(orderID = 1, foodID = "pizza", quantity = 2)

        orderItemRepository.delete(orderItem)

        verify(orderItemDao).deleteOrderItem(orderItem)
    }

    @Test
    fun testGetOrderItem() = runBlocking {
        val orderId = 1
        val foodId = "pizza"
        val expectedOrderItem = OrderItem(orderID = orderId, foodID = foodId, quantity = 2)

        `when`(orderItemDao.getOrderItemWithFoodIDAndOrderID(orderId, foodId)).thenReturn(expectedOrderItem)

        val result = orderItemRepository.getOrderItem(orderId, foodId)

        assertEquals(expectedOrderItem, result)
    }
}
