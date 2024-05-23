package com.example.fooddelivery.repository

import androidx.annotation.WorkerThread
import com.example.fooddelivery.data.Person
import com.example.fooddelivery.data.dao.PersonDao
import kotlinx.coroutines.flow.Flow

class PersonRepository(private val personDao: PersonDao) {


    @WorkerThread
    suspend fun upsert(person: Person) {
        personDao.upsertPerson(person)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getAllPerson(): List<Person>? {
        return personDao.getAllPerson()
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun getPersonWithEmail(email:String):Person? {
        return personDao.getPersonWithEmail(email)
    }
}