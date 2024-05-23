package com.example.fooddelivery.ui.auth.login

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
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
fun LoginScreen(name: String, viewModel: AuthViewModel = viewModel()) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var loginResult by remember { mutableStateOf<Any?>(null) }
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.onSecondary)
    ) {
        CustomTextField(email, { email = it }, KeyboardType.Email, label = "Email address")

        Spacer(modifier = Modifier.height(46.dp))

        CustomTextField(password, { password = it }, KeyboardType.Password, label = "Password")

        BasicText(
            modifier = Modifier.padding(start = 50.dp, top = 34.dp, end = 50.dp, bottom = 0.dp),
            text = "Forgot password?",
            style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.primary),
        )
        Spacer(modifier = Modifier.height(136.dp))

        FilledButton(onClick = {
            Log.i("ttttttttttttt", "adsfasdlf")
            coroutineScope.launch {
                viewModel.login(email, password) { isSuccess ->
                    loginResult = isSuccess
//                    Log.i("bool of login page",
//                        viewModel.login(email, password).toString()
//                    )
                }
            }
        }, text = "Login")
    }
}
