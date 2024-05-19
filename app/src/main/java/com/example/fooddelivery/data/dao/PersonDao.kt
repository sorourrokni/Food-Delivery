package com.example.fooddelivery.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Upsert
import com.example.fooddelivery.data.Order
import com.example.fooddelivery.data.Person

@Dao
interface PersonDao {
    @Upsert
    suspend fun upsertPerson(person: Person)
    @Delete
    suspend fun deletePerson(person: Person)
}