package com.chekincompose.ok

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.chekincompose.ok.features.lesson_3.MainScreen
import com.chekincompose.ok.features.lesson_3.OnboardingScreen
import com.chekincompose.ok.ui.theme.ChekInComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    ChekInComposeTheme {
        if (shouldShowOnboarding) {
            OnboardingScreen(onNextClick = { shouldShowOnboarding = false })
        } else {
            MainScreen()
        }
    }
}