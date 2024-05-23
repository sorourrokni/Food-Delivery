package com.example.fooddelivery.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.fooddelivery.data.Food
import kotlinx.coroutines.flow.Flow
import androidx.room.DeleteColumn as W

@Dao
interface FoodDao {
    @Upsert
     suspend fun upsertFood(food: Food)

    @Delete
    suspend fun deleteFood(food: Food)
    @Query("Delete from Food")
    suspend fun deleteAll()

    @Query("select * from Food")
    fun getAllFood(): Flow<List<Food>>

    @Query("select * from Food limit :number")
    fun getSomeFood(number:Int):Flow<List<Food>>

    @Query("select * from Food where name==:foodName")
    fun getFoodByName(foodName:String):Food?



}