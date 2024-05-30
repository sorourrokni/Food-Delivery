package com.example.fooddelivery.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.fooddelivery.navigation.NavControllerWithHistory
import com.example.fooddelivery.navigation.PaymentNavigationGraph
import com.example.fooddelivery.theme.FoodDeliveryTheme

class PaymentActivity:ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodDeliveryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    val navController = rememberNavController()
                    val navControllerWithHistory = remember { NavControllerWithHistory(navController) }

                    PaymentNavigationGraph(navController = navControllerWithHistory.navController,modifier= Modifier )


                }
            }
        }

    }
}