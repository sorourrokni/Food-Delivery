package com.example.fooddelivery.ui.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.fooddelivery.R
import com.example.fooddelivery.ui.auth.login.LoginScreen
import com.example.fooddelivery.ui.auth.signup.SignupScreen

@Composable
fun AuthLayout() {
    val scrollState = rememberScrollState()
    val tabTitles = AuthTab.values()
    var selectedTabIndex by remember { mutableIntStateOf(0) }
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
            Image(
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(start = 0.dp, top = 32.dp, end = 0.dp, bottom = 0.dp)
                    .size(164.16.dp, 164.16.dp)
            )
            TabRow(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(start = 32.dp, end = 32.dp),
                selectedTabIndex = selectedTabIndex,
                indicator = { tabPositions ->
                    TabRowDefaults.Indicator(
                        Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                        color = MaterialTheme.colorScheme.primary
                    )
                },
                containerColor = MaterialTheme.colorScheme.onPrimary,
                divider = {}
            ) {

                tabTitles.forEachIndexed { index, tab ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        text = {
                            Text(
                                text = tab.toString(),
                                color = if (selectedTabIndex == index) MaterialTheme.colorScheme.primaryContainer
                                else MaterialTheme.colorScheme.onTertiaryContainer,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    )
                }
            }

        }
        when (tabTitles[selectedTabIndex]) {
            AuthTab.LOGIN -> LoginScreen("login")
            AuthTab.SIGNUP -> SignupScreen("signup")
        }
    }
}