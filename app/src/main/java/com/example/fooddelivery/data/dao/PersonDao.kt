package com.example.fooddelivery.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.fooddelivery.data.Order
import com.example.fooddelivery.data.Person

@Dao
interface PersonDao {
    @Upsert
     fun upsertPerson(person: Person)
    @Delete
     fun deletePerson(person: Person)

    @Query ("select * from Person where email==:emailInput")
    fun getPersonWithEmail(emailInput:String):Person


}