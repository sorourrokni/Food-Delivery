package com.example.fooddelivery.ui.auth.lostconnection

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddelivery.R
import com.example.fooddelivery.component.FilledButton
import com.example.fooddelivery.navigation.NavControllerWithHistory
/**
 * Composable function that displays the Lost Connection screen.
 *
 * @param navControllerWithHistory The navigation controller with history support.
 * @param modifier The modifier to be applied to the composable.
 */
@Composable
fun LostConnectionScreen(
    navControllerWithHistory: NavControllerWithHistory,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .wrapContentSize(Alignment.Center)
            .fillMaxSize()
    ) {
        Image(
            painterResource(id = R.drawable.eva_wifi_off_fill), null,
            modifier = Modifier.padding(top = 251.dp)
        )
        Text(
            "No internet Connection",
            style = MaterialTheme.typography.bodyLarge,
            lineHeight = 32.81.sp
        )
        Text(
            "Your internet connection is currently\n" +
                    "not available please check or try again.",
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 17.sp,
            lineHeight = 19.92.sp,
            modifier = Modifier.padding(top = 10.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))

        FilledButton(
            onClick = { /*TODO*/ },
            text = "Try agin",
            color = MaterialTheme.colorScheme.primary,
            textColor = MaterialTheme.colorScheme.secondary
        )
    }
}

