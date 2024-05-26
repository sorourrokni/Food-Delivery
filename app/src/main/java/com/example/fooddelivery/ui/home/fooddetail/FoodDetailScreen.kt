package com.example.fooddelivery.ui.home.fooddetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.fooddelivery.R
import com.example.fooddelivery.component.FilledButton
import com.example.fooddelivery.component.FoodCaption
import com.example.fooddelivery.component.ImageSlider
import com.example.fooddelivery.data.Food
import com.example.fooddelivery.navigation.NavControllerWithHistory
import com.example.fooddelivery.viewModel.HomeViewModel

@Composable
fun FoodDetailScreen(
    name: String,
    modifier: Modifier = Modifier,
    navControllerWithHistory: NavControllerWithHistory,
    food: Food?,
    homeViewModel: HomeViewModel
) {

    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .verticalScroll(scrollState)
            .background(color = MaterialTheme.colorScheme.secondary),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .height(132.dp)
                .padding(start = 42.dp, top = 60.dp, end = 41.dp, bottom = 0.dp)
        ) {
            Image(
                modifier = Modifier.clickable {
                    navControllerWithHistory.popBackStack()
                },
                painter = painterResource(id = R.drawable.chevron_left),
                contentDescription = null,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primaryContainer)
            )
            Image(
                modifier = Modifier.clickable {

                },
                painter = painterResource(
                    id = R.drawable.ic_heart_unselected
                ),
                contentDescription = null,
            )
        }
        if (food != null) {
            ImageSlider(images = listOf(food.imageResId, food.imageResId, food.imageResId))
        }

        Column(modifier = Modifier.padding(start = 64.dp, end = 64.dp)) {
            if (food != null) {
                Text(
                    text = food.name,
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 46.dp, bottom = 12.dp)
                )
            }
            if (food != null) {
                Text(
                    text = "${food.price} $",
                    style = MaterialTheme.typography.displayMedium.copy(color = MaterialTheme.colorScheme.primary),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 42.dp)
                )
            }
            FoodCaption(
                title = "Delivery info",
                caption = "Delivered between monday aug and thursday 20 from 8pm to 91:32 pm"
            )
            Spacer(modifier = Modifier.height(42.dp))
            FoodCaption(
                title = "Return policy",
                caption = "Delivered between monday aug and thursday 20 from 8pm to 91:32 pm"
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        FilledButton(
            onClick = { /*TODO*/ },
            text = "Add to cart",
            color = MaterialTheme.colorScheme.primary,
            textColor = MaterialTheme.colorScheme.secondary
        )
    }
}