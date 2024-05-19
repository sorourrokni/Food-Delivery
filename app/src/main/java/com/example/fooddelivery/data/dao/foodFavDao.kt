package com.example.fooddelivery.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Upsert
import com.example.fooddelivery.data.Address
import com.example.fooddelivery.data.foodFav

@Dao
interface foodFavDao {
    @Upsert
    suspend fun upsertFoodFav(foodFav: foodFav)
    @Delete
    suspend fun deleteFoodFav(foodFav: foodFav)
}