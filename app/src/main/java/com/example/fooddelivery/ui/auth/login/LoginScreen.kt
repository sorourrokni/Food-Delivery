package com.example.fooddelivery.ui.auth.login

import android.content.Intent
import android.util.Log
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
import androidx.core.content.ContextCompat.startActivity
import com.example.fooddelivery.AuthActivity
import com.example.fooddelivery.HomeActivity
import com.example.fooddelivery.component.CustomTextField
import com.example.fooddelivery.component.FilledButton
import com.example.fooddelivery.navigation.NavControllerWithHistory
import com.example.fooddelivery.navigation.NavigationItem
import com.example.fooddelivery.navigation.Screen
import com.example.fooddelivery.viewModel.authViewModel

@Composable
fun LoginScreen(    authVM: authViewModel,navControllerWithHistory: NavControllerWithHistory,name:String, modifier: Modifier = Modifier) {
    val mContext = LocalContext.current
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.onSecondary)
    ) {
       var email= CustomTextField(KeyboardType.Email, label = "Email address")

        Spacer(modifier = Modifier.height(46.dp))

        var password=CustomTextField(KeyboardType.Password, label = "Password")

        BasicText(
            modifier = Modifier.padding(start = 50.dp, top = 34.dp, end = 50.dp, bottom = 0.dp)
                .clickable{navControllerWithHistory.navigate(Screen.ForgotPass.route) }
                ,
            text = "Forgot password?",
            style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.primary),

        )
        Spacer(modifier = Modifier.height(136.dp))

        FilledButton(onClick = {
                               if(authVM.login(email,password)){

                                   mContext.startActivity(Intent(mContext,HomeActivity::class.java))
                               }
        }, text = "Login")
    }
}
