package com.example.fooddelivery.repository

import com.example.fooddelivery.R
import com.example.fooddelivery.data.Food
import com.example.fooddelivery.data.dao.FoodDao
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class FoodRepositoryTest {

    private lateinit var foodRepository: FoodRepository
    private lateinit var foodDao: FoodDao

    @Before
    fun setup() {
        foodDao = mock(FoodDao::class.java)
        foodRepository = FoodRepository(foodDao)
    }

    @Test
    fun testUpsert() = runBlocking {
        val food = Food(name = "Pizza", description = "pizza", price = 1900, imageResId = R.drawable.food_1)


        foodRepository.upsert(food)

        verify(foodDao).upsertFood(food)
    }

    @Test
    fun testGetFoodInfo() = runBlocking {
        val name = "Pizza"
        val expectedFood = Food(name = "Pizza", description = "pizza", price = 1900, imageResId = R.drawable.food_1)


        `when`(foodDao.getFoodByName(name)).thenReturn(expectedFood)

        val result = foodRepository.getFoodInfo(name)

        assertEquals(expectedFood, result)
    }
}
