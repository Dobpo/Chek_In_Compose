package com.chekincompose.ok

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.chekincompose.ok.ui.theme.ChekInComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Message(name = "Compose")
        }
    }
}

@Composable
fun Message(name: String) {
    Text(text = "Hello $name")
}

@Preview
@Composable
fun PreviewMessage() {
    Message(name = "John Cena")
}