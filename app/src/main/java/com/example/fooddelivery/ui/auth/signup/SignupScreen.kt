package com.example.fooddelivery.ui.auth.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.fooddelivery.component.CustomTextField
import com.example.fooddelivery.component.FilledButton
import com.example.fooddelivery.viewModel.AuthViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch

@Composable
fun SignupScreen(name: String, viewModel: AuthViewModel = viewModel()) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var signupResult by remember { mutableStateOf<Any?>(null) }
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.onSecondary)
    ) {
        CustomTextField(email, {email = it }, KeyboardType.Email, label = "Email address")

        Spacer(modifier = Modifier.height(46.dp))

        CustomTextField(password, {password = it}, KeyboardType.Password, label = "Password")

        Spacer(modifier = Modifier.height(190.dp))

        FilledButton(onClick = {
            coroutineScope.launch {
                viewModel.signUp(email, password) { isSuccess ->
                    signupResult = isSuccess
                }
            }
//                               Log.i("signup log bool", viewModel.signUp(email, password).toString())
        }, text = "Sign-up")

    }
}
