package com.chekincompose.ok.features.lesson_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.chekincompose.ok.ui.theme.ChekInComposeTheme

class Lesson2Activity : ComponentActivity() {

    private lateinit var viewModel: Lesson2ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(Lesson2ViewModel::class.java)

        setContent {
            ChekInComposeTheme {
                MainScreen(viewModel)
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: Lesson2ViewModel) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ClickCounter(viewModel)
        Spacer(modifier = Modifier.height(8.dp))
        ResetButton(viewModel)
    }
}

@Composable
fun ClickCounter(viewModel: Lesson2ViewModel) {
    viewModel.run {
        Button(onClick = ::incrementCount) {
            val count by clickCountLiveData.observeAsState()
            Text(text = "I was clicked $count times")
        }
    }
}

@Composable
fun ResetButton(viewModel: Lesson2ViewModel) {
    viewModel.run {
        Button(onClick = ::resetCount) {
            Text(text = "Reset")
        }
    }
}