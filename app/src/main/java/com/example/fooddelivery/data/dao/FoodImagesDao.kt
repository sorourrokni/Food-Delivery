package com.example.fooddelivery.data.dao

import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.fooddelivery.data.Food
import com.example.fooddelivery.data.FoodImages
import kotlinx.coroutines.flow.Flow

interface FoodImagesDao {
    @Upsert
    suspend fun upsertFoodImage(foodImages: FoodImages)

    @Delete
    suspend fun deleteFoodImage(foodImages: FoodImages)

    @Query("Delete from Food")
    suspend fun deleteAll()

    @Query("select * from FoodImages")
    suspend fun getAllFoodImages(): List<FoodImages>?

    @Query("select * from FoodImages where foodID==:foodName")
    fun getFoodImagesByFoodName(foodName:String): List<FoodImages>?
}