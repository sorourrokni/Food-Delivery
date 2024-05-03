package com.example.fooddelivery

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fooddelivery.data.Food
import com.example.fooddelivery.ui.home.history.HistoryPage
import com.example.fooddelivery.theme.FoodDeliveryTheme
import com.example.fooddelivery.ui.home.favourite.Favourite

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodDeliveryTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background

                )
                {
//                    Food("Veggie tomato mix", "N1,900", R.drawable.food_1),
//                    Food("Egg and cucumber", "N1,900", R.drawable.food_2),
//                    Food("Egg and cucumber", "N1,900", R.drawable.food_3),
//                    Food("Egg and cucumber", "N1,900", R.drawable.food_4),
//                    Food("Egg and cucumber", "N1,900", R.drawable.food_1),
                    val food_list= ArrayList<Food>()
                    food_list.add(Food("Veggie tomato mix", "N1,900", R.drawable.food_1,true))
                    food_list.add(Food("Veggie tomato mix", "N1,900", R.drawable.food_1,true))
                    food_list.add(Food("Veggie tomato mix", "N1,900", R.drawable.food_1,true))



                    Favourite(food_list = food_list)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodDeliveryTheme {
        Greeting("Android")
    }
}