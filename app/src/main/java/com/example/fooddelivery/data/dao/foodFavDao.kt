package com.example.fooddelivery.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fooddelivery.data.Food
import com.example.fooddelivery.data.FoodFavorite
import kotlinx.coroutines.flow.Flow

@Dao
interface foodFavDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFoodFav(FoodFavorite: FoodFavorite)
    @Delete
     fun deleteFoodFav(FoodFavorite: FoodFavorite)
    @Query("select name,description,price,imageResId from FoodFavorite natural join food where FoodFavorite.userID==:email")
    fun getAllFoodFavByUserID(email:String): Flow<List<Food>>
    @Query("select FoodFavorite.foodID,FoodFavorite.userID from FoodFavorite , person , food where FoodFavorite.userID==:email and FoodFavorite.foodID==:name")
    fun userLikeFood(email:String,name:String):FoodFavorite?


}