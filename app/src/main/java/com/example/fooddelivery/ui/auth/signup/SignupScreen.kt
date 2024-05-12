package com.example.fooddelivery.ui.auth.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.fooddelivery.component.CustomTextField
import com.example.fooddelivery.component.FilledButton

@Composable
fun SignupScreen(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.onSecondary)
    ) {
        CustomTextField(KeyboardType.Email, label = "Email address")

        Spacer(modifier = Modifier.height(46.dp))

        CustomTextField(KeyboardType.Password, label = "Password")

        Spacer(modifier = Modifier.height(190.dp))

        FilledButton(onClick = { /*TODO*/ }, text = "Sign-up")

    }
}
