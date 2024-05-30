package com.example.fooddelivery.repository

import com.example.fooddelivery.R
import com.example.fooddelivery.data.Person
import com.example.fooddelivery.data.dao.PersonDao
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class PersonRepositoryTest {

    private lateinit var personRepository: PersonRepository
    private lateinit var personDao: PersonDao

    @Before
    fun setup() {
        personDao = mock(PersonDao::class.java)
        personRepository = PersonRepository(personDao)
    }

    @Test
    fun testUpsert() = runBlocking {
        val person = Person(
            "bob.jones@example.com",
            "555-8765",
            "Bob Jones",
            "password789",
            R.drawable.person1
        )

        personRepository.upsert(person)

        verify(personDao).upsertPerson(person)
    }

    @Test
    fun testGetPersonWithEmail() = runBlocking {
        val email = "test@example.com"
        val expectedPerson = Person(
            email,
            "555-8765",
            "Bob Jones",
            "password789",
            R.drawable.person1
        )

        `when`(personDao.getPersonWithEmail(email)).thenReturn(expectedPerson)

        val result = personRepository.getPersonWithEmail(email)

        assertEquals(expectedPerson, result)
    }
}
