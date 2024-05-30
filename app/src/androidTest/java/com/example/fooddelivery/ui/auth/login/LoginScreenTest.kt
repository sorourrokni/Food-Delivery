package com.example.fooddelivery.ui.auth.login

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.example.fooddelivery.navigation.NavControllerWithHistory
import com.example.fooddelivery.ui.auth.login.LoginScreen
import com.example.fooddelivery.viewModel.AuthViewModel
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Rule
import org.junit.Test

class LoginScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun loginScreen_displaysUIElements() {
        // Given
        val authViewModel = mockk<AuthViewModel>(relaxed = true)
        val navController = NavControllerWithHistory()

        // When
        composeTestRule.setContent {
            LoginScreen(authViewModel, navController, "login")
        }

        // Then
        composeTestRule.onNodeWithTag("EmailTextField").assertIsDisplayed()
        composeTestRule.onNodeWithTag("PasswordTextField").assertIsDisplayed()
        composeTestRule.onNodeWithTag("ForgotPassword").assertIsDisplayed()
        composeTestRule.onNodeWithTag("LoginButton").assertIsDisplayed()
    }

    @Test
    fun loginScreen_navigatesToForgotPassword() {
        // Given
        val authViewModel = mockk<AuthViewModel>(relaxed = true)
        val navController = NavControllerWithHistory()

        // When
        composeTestRule.setContent {
            LoginScreen(authViewModel, navController, "login")
        }

        // Then
        composeTestRule.onNodeWithTag("ForgotPassword").performClick()
        assert(navController.currentRoute == "forgot_password")
    }

    @Test
    fun loginScreen_performsLogin() {
        // Given
        val authViewModel = mockk<AuthViewModel>()
        val navController = NavControllerWithHistory()

        // Mock the login function to return true
        coEvery { authViewModel.login(any(), any()) } returns true

        // When
        composeTestRule.setContent {
            LoginScreen(authViewModel, navController, "login")
        }

        // Perform login
        composeTestRule.onNodeWithTag("LoginButton").performClick()

        // Then
        // Assert that navigation to HomeActivity is performed
        // You may need to mock the startActivity function and verify that it was called with the correct intent
    }
}
