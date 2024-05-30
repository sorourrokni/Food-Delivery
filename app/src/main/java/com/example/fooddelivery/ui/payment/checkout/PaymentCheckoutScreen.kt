package com.example.fooddelivery.ui.payment.checkout

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.fooddelivery.R
import com.example.fooddelivery.component.DeliveryMethodCard
import com.example.fooddelivery.component.FilledButton
import com.example.fooddelivery.component.PaymentMethodCard
import com.example.fooddelivery.navigation.NavControllerWithHistory
import com.example.fooddelivery.navigation.Screen

@Composable
fun PaymentCheckoutScreen(
    navControllerWithHistory: NavControllerWithHistory,
    total: Int,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Column(
        Modifier
            .verticalScroll(scrollState)
            .background(color = MaterialTheme.colorScheme.onSecondary)
    ) {
        Row(
            modifier = Modifier
                .padding(start = 40.dp, top = 60.dp)
                .background(color = MaterialTheme.colorScheme.onSecondary)
        ) {
            Image(painterResource(id = R.drawable.chevron_left), null)
            Text(
                "Checkout",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(start = 96.dp)
            )
        }
        Row(modifier = Modifier.padding(start = 54.dp, top = 40.dp)) {
            Text("Payment", style = MaterialTheme.typography.headlineLarge)
        }
        PaymentMethodCard(modifier = Modifier.padding(start = 50.dp, end = 46.dp))
        DeliveryMethodCard(modifier = Modifier.padding(start = 50.dp, end = 46.dp))
        Row(Modifier.padding(start = 50.dp, end = 46.dp, top = 38.dp)) {
            Text("Total", style = MaterialTheme.typography.bodyMedium)
            Text(
                "$total",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(start = 199.dp)
            )
        }
        Spacer(modifier = Modifier.padding(top = 48.dp))
        FilledButton(
            onClick = { navControllerWithHistory.navigate(Screen.Cart.route) },
            text = "Proceed to payment",
            color = MaterialTheme.colorScheme.primary,
            textColor = MaterialTheme.colorScheme.secondary
        )

    }
}