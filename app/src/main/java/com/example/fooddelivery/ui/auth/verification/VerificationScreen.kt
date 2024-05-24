package com.example.fooddelivery.ui.auth.verification

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.fooddelivery.R
import com.example.fooddelivery.component.FilledButton
import com.example.fooddelivery.component.VerificationCodeField
import com.example.fooddelivery.navigation.NavControllerWithHistory
import com.example.fooddelivery.viewModel.authViewModel

@Composable
fun VerificationScreen(authVM: authViewModel, modifier: Modifier =Modifier, navControllerWithHistory: NavControllerWithHistory) {
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
            Column (modifier= Modifier
                .align(Alignment.Center)
                .wrapContentSize(Alignment.Center)

            ){
                Row(modifier=Modifier.fillMaxWidth().wrapContentSize(Alignment.Center)){
                Image(
                    painter = painterResource(id = R.drawable.vuesax),
                    contentDescription = null,
                    modifier = Modifier
//                    .align(Alignment.Center)
                        .size(100.dp, 100.dp)
                        .padding( top = 32.dp)
                )

                }
                Row(modifier=Modifier.fillMaxWidth().wrapContentSize(Alignment.Center)){

                Text(text = "\nVerification", style = MaterialTheme.typography.titleMedium, color = Color(0xffFA4A0C)
                )}

                Row(modifier=Modifier.fillMaxWidth().wrapContentSize(Alignment.Center)) {

                    Text(
                        text = "\nEnter your verification code",
                        style = MaterialTheme.typography.labelLarge,
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        var number= VerificationCodeField(4).take(4)
        Spacer(modifier = Modifier.height(280.dp))

        FilledButton(onClick = { /*TODO*/ }, text = "Submit")

    }
}




