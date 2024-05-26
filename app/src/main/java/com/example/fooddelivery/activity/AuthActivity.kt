package com.example.fooddelivery.activity

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
import com.example.fooddelivery.data.ProjectDataBase
import com.example.fooddelivery.R
import com.example.fooddelivery.navigation.AuthNavigationGraph
import com.example.fooddelivery.navigation.NavControllerWithHistory
import com.example.fooddelivery.theme.FoodDeliveryTheme
import com.example.fooddelivery.viewModel.authViewModel

class AuthActivity:ComponentActivity() {
    private val authVM: authViewModel by viewModels {
        authViewModel.AuthViewModelFactory((application as ProjectDataBase).personRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.circle_1)
        setContent {
            FoodDeliveryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    val navController = rememberNavController()
                    val navControllerWithHistory = remember { NavControllerWithHistory(navController) }

                    AuthNavigationGraph(authVM,navController = navControllerWithHistory.navController,modifier=Modifier )
                }
            }
        }

    }
}