package com.example.fooddelivery.data.dao

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.fooddelivery.data.Food
import com.example.fooddelivery.data.dao.FoodDao
import kotlinx.coroutines.flow.first
import com.example.fooddelivery.data.DataBase
import com.example.fooddelivery.R
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FoodDaoTest {

    private lateinit var foodDao: FoodDao
    private lateinit var testDatabase: DataBase

    @Before
    fun setup() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        testDatabase = Room.inMemoryDatabaseBuilder(context, DataBase::class.java).build()
        foodDao = testDatabase.foodDao()
    }

    @After
    fun teardown() {
        testDatabase.close()
    }

    @Test
    fun testInsertAndGetFoodByName() = runBlocking {
        val food = Food(name = "Pizza", description = "Delicious pizza", price = 1900, imageResId = R.drawable.food_1)
        foodDao.upsertFood(food)

        val retrievedFood = foodDao.getFoodByName("Pizza")
        assert(retrievedFood != null)
        assert(retrievedFood?.name == food.name)
        assert(retrievedFood?.description == food.description)
    }

}
