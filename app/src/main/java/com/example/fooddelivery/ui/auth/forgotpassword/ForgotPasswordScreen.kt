package com.example.fooddelivery.ui.auth.forgotpassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.fooddelivery.R
import com.example.fooddelivery.component.AuthTextField
import com.example.fooddelivery.component.FilledButton
import com.example.fooddelivery.navigation.NavControllerWithHistory
import com.example.fooddelivery.navigation.Screen
import com.example.fooddelivery.viewModel.authViewModel

@Composable
fun ForgotPasswordScreen(
    authVM: authViewModel,
    navControllerWithHistory: NavControllerWithHistory,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .background(color = MaterialTheme.colorScheme.onSecondary)
    ) {
        Box(
            modifier = Modifier
                .height(382.dp)
                .fillMaxWidth()
                .padding(bottom = 64.dp)
                .background(
                    color = MaterialTheme.colorScheme.onPrimary,
                    shape = RoundedCornerShape(30.dp).copy(
                        topStart = CornerSize(0.dp),
                        topEnd = CornerSize(0.dp)
                    )
                )
        )
        {
            Column(
                modifier = Modifier
                    .padding(start = 0.dp, top = 0.dp, end = 0.dp, bottom = 0.dp)
                    .align(Alignment.Center)
                    .wrapContentSize(Alignment.Center)

            ) {
                Image(
                    painter = painterResource(id = R.drawable.lock),
                    contentDescription = null,
                    modifier = Modifier
//                    .align(Alignment.Center)
                        .size(164.16.dp, 164.16.dp)
                        .padding(start = 0.dp, top = 32.dp, end = 0.dp, bottom = 0.dp)
                )

                Text(
                    text = "\nForgot Password",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color(0xffFA4A0C),
                    modifier = Modifier.padding(start = 8.dp)
                )


                Text(
                    text = "Enter your registered email",
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.padding(8.dp)
                )

            }
        }
        var email = AuthTextField(KeyboardType.Email, label = "Email address")

        Spacer(modifier = Modifier.height(280.dp))

        FilledButton(
            onClick = {
                navControllerWithHistory.navigate(Screen.Verification.route)
                authVM.sendEmail(email)
            },
            text = "Enter email",
            color = MaterialTheme.colorScheme.primary,
            textColor = MaterialTheme.colorScheme.secondary
        )

    }
}

