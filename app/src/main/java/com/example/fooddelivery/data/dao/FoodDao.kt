package com.example.fooddelivery.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Upsert
import com.example.fooddelivery.data.Address
import com.example.fooddelivery.data.Food

@Dao
interface FoodDao {
    @Insert
     fun insertFood(food: Food)

    @Delete
    suspend fun deleteFood(food: Food)
}