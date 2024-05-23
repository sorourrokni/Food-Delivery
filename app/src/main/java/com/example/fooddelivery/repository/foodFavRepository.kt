package com.example.fooddelivery.repository

import androidx.annotation.WorkerThread
import com.example.fooddelivery.data.Food
import com.example.fooddelivery.data.FoodFavorite
import com.example.fooddelivery.data.dao.foodFavDao
import kotlinx.coroutines.flow.Flow

class foodFavRepository(private val foodFavDao: foodFavDao,email:String) {

    val allUserFavoriteFood: Flow<List<Food>> = foodFavDao.getAllFoodFavByUserID(email)

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(foodFav:FoodFavorite) {
        foodFavDao.insertFoodFav(foodFav)
    }

}