package com.example.fooddelivery.ui.auth

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.example.fooddelivery.navigation.NavControllerWithHistory
import com.example.fooddelivery.ui.auth.AuthLayout
import com.example.fooddelivery.ui.auth.AuthTab
import com.example.fooddelivery.viewModel.AuthViewModel
import org.junit.Rule
import org.junit.Test

class AuthLayoutTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun authLayout_displaysCorrectTabs() {
        // Given
        val authViewModel = AuthViewModel(/* pass necessary mocks */)
        val navController = NavControllerWithHistory()

        // When
        composeTestRule.setContent {
            AuthLayout(authViewModel, navController)
        }

        // Then
        composeTestRule.onNodeWithTag("TabRow").assertExists()
        composeTestRule.onNodeWithTag("LoginTab").assertExists()
        composeTestRule.onNodeWithTag("SignupTab").assertExists()
    }

    @Test
    fun authLayout_showsLoginScreenByDefault() {
        // Given
        val authViewModel = AuthViewModel(/* pass necessary mocks */)
        val navController = NavControllerWithHistory()

        // When
        composeTestRule.setContent {
            AuthLayout(authViewModel, navController)
        }

        // Then
        composeTestRule.onNodeWithTag("LoginScreen").assertIsDisplayed()
    }

    @Test
    fun authLayout_showsSignupScreenOnTabChange() {
        // Given
        val authViewModel = AuthViewModel(/* pass necessary mocks */)
        val navController = NavControllerWithHistory()

        // When
        composeTestRule.setContent {
            AuthLayout(authViewModel, navController)
        }

        // Then
        composeTestRule.onNodeWithTag("SignupTab").performClick()
        composeTestRule.onNodeWithTag("SignupScreen").assertIsDisplayed()
    }
}
