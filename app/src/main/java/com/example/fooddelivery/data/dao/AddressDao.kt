package com.example.fooddelivery.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.fooddelivery.data.Address
import kotlinx.coroutines.flow.Flow

@Dao
interface AddressDao {
    @Upsert
     fun upsertAddress(address: Address)
    @Delete
     fun deleteAddress(address:Address)

    @Query("Select * from Address where user==:userID")
    fun getUserAddress(userID:String): Flow<Address>


}