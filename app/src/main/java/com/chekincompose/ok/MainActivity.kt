package com.chekincompose.ok

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.chekincompose.ok.features.lesson_3.MainScreen
import com.chekincompose.ok.ui.theme.ChekInComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ChekInComposeTheme {
                //OnboardingScreen()
                MainScreen()
            }
        }
    }
}