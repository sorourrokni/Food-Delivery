package com.example.fooddelivery.ui.auth.signup

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.fooddelivery.activity.HomeActivity
import com.example.fooddelivery.component.CustomTextField
import com.example.fooddelivery.component.FilledButton
import com.example.fooddelivery.navigation.NavControllerWithHistory
import com.example.fooddelivery.viewModel.authViewModel

@Composable
fun SignupScreen(
    authVM: authViewModel,
    navControllerWithHistory: NavControllerWithHistory,
    name: String,
    modifier: Modifier = Modifier
) {
    val mContext = LocalContext.current

    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.onSecondary)
    ) {
        val email = CustomTextField(KeyboardType.Email, label = "Email address")

        Spacer(modifier = Modifier.height(46.dp))

        val passwrod = CustomTextField(KeyboardType.Password, label = "Password")

        Spacer(modifier = Modifier.height(190.dp))

        FilledButton(
            onClick = {
                authVM.createNewUser(email, passwrod)
                mContext.startActivity(Intent(mContext, HomeActivity::class.java))

            },
            text = "Sign-up",
            color = MaterialTheme.colorScheme.primary,
            textColor = MaterialTheme.colorScheme.secondary
        )

    }
}
