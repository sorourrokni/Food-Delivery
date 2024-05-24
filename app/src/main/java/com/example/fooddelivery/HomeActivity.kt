package com.example.fooddelivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.fooddelivery.navigation.NavControllerWithHistory
import com.example.fooddelivery.theme.FoodDeliveryTheme
import com.example.fooddelivery.viewModel.HomeViewModel
import com.example.fooddelivery.viewModel.ProfileViewModel

class HomeActivity : ComponentActivity() {
    private lateinit var email: String

    private val homeVM: HomeViewModel by viewModels {

        HomeViewModel.HomeViewModelFactory(
            (application as ProjectDataBase).foodRepository,
            (application as ProjectDataBase).foodFavRepository,
            (application as ProjectDataBase).orderRepository,
            email = email,
            (application as ProjectDataBase).orderItemRepository,
            (application as ProjectDataBase).addressRepository
        )
    }

    private val profileVM: ProfileViewModel by viewModels {
        ProfileViewModel.ProfileViewModelFactory(
            (application as ProjectDataBase).personRepository,
            (application as ProjectDataBase).addressRepository,
            email = email
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.circle_1)
        email = intent.getStringExtra("email") ?: ""
        setContent {

            FoodDeliveryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val navControllerWithHistory =
                        remember { NavControllerWithHistory(navController) }
                    MainScreen(
                        homeViewModel = homeVM,
                        profileViewModel = profileVM,
                        navControllerWithHistory = navControllerWithHistory
                    )
                }
            }
        }
    }
}