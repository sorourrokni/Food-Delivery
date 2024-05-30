package com.example.fooddelivery.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.example.fooddelivery.data.Person
import com.example.fooddelivery.R
import com.example.fooddelivery.repository.PersonRepository
import com.example.fooddelivery.viewModel.AuthViewModel
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import androidx.lifecycle.viewModelScope

@ExperimentalCoroutinesApi
class AuthViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var authViewModel: AuthViewModel
    private lateinit var personRepository: PersonRepository

    @Before
    fun setUp() {
        personRepository = mockk()
        authViewModel = AuthViewModel(personRepository)
    }

    @Test
    fun `test login when person exists and password matches`() = runBlockingTest {
        // Given
        val email = "test@example.com"
        val password = "password"
        val person = Person(
            "test@example.com",
            "555-8765",
            "Bob Jones",
            "password",
            R.drawable.person1
        )
        coEvery { personRepository.getPersonWithEmail(email) } returns person

        // When
        val result = authViewModel.login(email, password)

        // Then
        assertTrue(result)
    }

    @Test
    fun `test login when person exists but password does not match`() = runBlockingTest {
        // Given
        val email = "test@example.com"
        val password = "password"
        val person = Person(
            "test@example.com",
            "555-8765",
            "Bob Jones",
            "incorrect_password",
            R.drawable.person1
        )
        coEvery { personRepository.getPersonWithEmail(email) } returns person

        // When
        val result = authViewModel.login(email, password)

        // Then
        assertFalse(result)
    }

    @Test
    fun `test login when person does not exist`() = runBlockingTest {
        // Given
        val email = "nonexistent@example.com"
        coEvery { personRepository.getPersonWithEmail(email) } returns null

        // When
        val result = authViewModel.login(email, "password")

        // Then
        assertFalse(result)
    }

    @Test
    fun `test signup for an existing user`() = runBlockingTest {
        // Given
        val email = "existinguser@example.com"
        val password = "password"
        val existingUser = Person(
            "existinguser@example.com",
            "555-8765",
            "Bob Jones",
            "password",
            R.drawable.person1
        )
        coEvery { personRepository.getPersonWithEmail(email) } returns existingUser

        // When
        val result = authViewModel.signUp(email, password)

        // Then
        assertFalse(result)
    }

    @Test
    fun `test sending email`() = runBlockingTest {
        // Given
        val email = "test@example.com"

        // When
        authViewModel.sendEmail(email)

        // Then: Verify that verificationCode is set and email is sent
        assertTrue(authViewModel.verificationCode != 0)
        // Verify the email sending behavior
    }

    @Test
    fun `test verification with correct code`() {
        // Given
        val code = 1234
        authViewModel.verificationCode = code

        // When
        val result = authViewModel.verification(code)

        // Then
        assertTrue(result)
    }

    @Test
    fun `test verification with incorrect code`() {
        // Given
        val correctCode = 1234
        val incorrectCode = 5678
        authViewModel.verificationCode = correctCode

        // When
        val result = authViewModel.verification(incorrectCode)

        // Then
        assertFalse(result)
    }
}
