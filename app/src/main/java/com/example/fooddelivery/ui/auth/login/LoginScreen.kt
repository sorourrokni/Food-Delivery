package com.example.fooddelivery.ui.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.fooddelivery.component.CustomTextField
import com.example.fooddelivery.component.FilledButton

@Composable
fun LoginScreen(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.onSecondary)
    ) {
        CustomTextField(KeyboardType.Email, label = "Email address")

        Spacer(modifier = Modifier.height(46.dp))

        CustomTextField(KeyboardType.Password, label = "Password")

        BasicText(
            modifier = Modifier.padding(start = 50.dp, top = 34.dp, end = 50.dp, bottom = 0.dp),
            text = "Forgot password?",
            style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.primary),
        )
        Spacer(modifier = Modifier.height(136.dp))

        FilledButton(onClick = { /*TODO*/ }, text = "Login")
    }
}
