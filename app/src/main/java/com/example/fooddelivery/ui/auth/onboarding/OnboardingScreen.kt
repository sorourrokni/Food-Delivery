package com.example.fooddelivery.ui.auth.onboarding

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddelivery.R
import com.example.fooddelivery.activity.AuthActivity
import com.example.fooddelivery.component.FilledButton

@Composable
fun OnBoardingScreen() {
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(color = MaterialTheme.colorScheme.onErrorContainer)
            .verticalScroll(scrollState)
    ) {
        Column(modifier = Modifier.padding(start = 42.dp, top = 42.dp)) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 64.dp, height = 64.dp)
                    .padding(bottom = 16.dp, start = 8.dp)

            )
            Text(
                modifier = Modifier.padding(bottom = 42.dp),
                text = "Food for \n" +
                        "Everyone",
                style = MaterialTheme.typography.displayLarge.copy(
                    fontSize = 65.sp,
                    lineHeight = 56.sp, color = MaterialTheme.colorScheme.onPrimary

                ),
            )
        }
        Box() {
            Image(
                painter = painterResource(id = R.drawable.toy_faces),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 546.3.dp, height = 453.07.dp)
                    .align(Alignment.CenterStart)
            )
            Box(
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(
                        brush = Brush.linearGradient(
                            start = Offset(0f, 0f),
                            end = Offset(0f, 200f),
                            colors = listOf(
                                MaterialTheme.colorScheme.onErrorContainer.copy(alpha = 0.1f),
                                MaterialTheme.colorScheme.onErrorContainer
                            )

                        )
                    )
            )
        }
        Row(modifier = Modifier.padding(top = 16.dp)) {
            FilledButton(
                onClick = {
                    val intent = Intent(context, AuthActivity::class.java)
                    context.startActivity(intent)
                },
                text = "Get started",
                color = MaterialTheme.colorScheme.onPrimary,
                textColor = MaterialTheme.colorScheme.primary
            )
        }
    }
}