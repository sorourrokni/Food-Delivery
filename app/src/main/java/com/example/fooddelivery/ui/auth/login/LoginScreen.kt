package com.example.fooddelivery.ui.auth.login

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
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
import com.example.fooddelivery.navigation.Screen
import com.example.fooddelivery.viewModel.authViewModel
/**
 * Composable function that displays the login screen.
 *
 * @param authVM The ViewModel instance for authentication-related operations.
 * @param navControllerWithHistory The navigation controller with history support.
 * @param name The name of the user (not currently used in the function).
 * @param modifier The modifier to be applied to the composable.
 */
@Composable
fun LoginScreen(
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
        var email = CustomTextField(KeyboardType.Email, label = "Email address")

        Spacer(modifier = Modifier.height(46.dp))

        var password = CustomTextField(KeyboardType.Password, label = "Password")

        BasicText(
            modifier = Modifier
                .padding(start = 50.dp, top = 34.dp, end = 50.dp, bottom = 0.dp)
                .clickable { navControllerWithHistory.navigate(Screen.ForgotPass.route) },
            text = "Forgot password?",
            style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.primary),

            )
        Spacer(modifier = Modifier.height(136.dp))

        FilledButton(
            onClick = {
                if (authVM.login(email, password)) {
                    val intent = Intent(mContext, HomeActivity::class.java)
                    intent.putExtra("email", email)
                    mContext.startActivity(intent)
                }
            },
            text = "Login",
            color = MaterialTheme.colorScheme.primary,
            textColor = MaterialTheme.colorScheme.secondary
        )
    }
}
