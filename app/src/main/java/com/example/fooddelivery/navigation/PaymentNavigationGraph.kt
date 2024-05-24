package com.example.fooddelivery.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.fooddelivery.data.Food
import com.example.fooddelivery.ui.auth.AuthLayout
import com.example.fooddelivery.ui.auth.forgotpassword.ForgotPasswordScreen
import com.example.fooddelivery.ui.auth.lostconnection.LostConnectionScreen
import com.example.fooddelivery.ui.auth.verification.VerificationScreen
import com.example.fooddelivery.ui.payment.cart.CartScreen
import com.example.fooddelivery.ui.payment.checkout.DeliveryCheckoutScreen
import com.example.fooddelivery.ui.payment.checkout.PaymentCheckoutScreen
import com.example.fooddelivery.viewModel.authViewModel
import java.util.Collections.list

@Composable

fun PaymentNavigationGraph( navController: NavHostController, modifier: Modifier) {
    val foodList:List<Food> = listOf()
    val navControllerWithHistory = remember { NavControllerWithHistory(navController) }
    val fakePerson=FakeData().person1
    val fakeAddress=FakeData().address1


    NavHost(
        navController = navControllerWithHistory.navController,
        startDestination = PaymentNavigationItem.Delivery.route,
        modifier = modifier
    ) {

        composable(PaymentNavigationItem.Payment.route) {
            PaymentCheckoutScreen(navControllerWithHistory = navControllerWithHistory,100)
        }
        composable(PaymentNavigationItem.Cart.route) {
            CartScreen( navControllerWithHistory= navControllerWithHistory,foodList)
        }
        composable(PaymentNavigationItem.Delivery.route) {
            DeliveryCheckoutScreen(navControllerWithHistory= navControllerWithHistory,fakeAddress,10,Modifier,fakePerson)
        }

    }
}
