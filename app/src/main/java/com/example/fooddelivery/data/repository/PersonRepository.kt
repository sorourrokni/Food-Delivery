package com.example.fooddelivery.data.repository

import androidx.annotation.WorkerThread
import com.example.fooddelivery.data.Person
import com.example.fooddelivery.data.dao.PersonDao
import kotlinx.coroutines.flow.Flow

class PersonRepository(private val personDao: PersonDao,email:String) {

    val person: Flow<Person?> = personDao.getPersonWithEmail(email)

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun upsert(person: Person) {
        personDao.upsertPerson(person)
    }
}