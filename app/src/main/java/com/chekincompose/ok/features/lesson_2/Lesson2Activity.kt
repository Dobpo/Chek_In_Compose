package com.chekincompose.ok.features.lesson_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chekincompose.ok.extension.showMessage
import com.chekincompose.ok.models.SampleData
import com.chekincompose.ok.ui.theme.ChekInComposeTheme

class Lesson2Activity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ChekInComposeTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(
    viewModel: Lesson2ViewModel = viewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(MaterialTheme.colors.surface),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val context = LocalContext.current

        ClickCounter(viewModel)
        Spacer(modifier = Modifier.height(8.dp))
        ResetButton(viewModel)
        Divider(modifier = Modifier.padding(start = 8.dp, end = 8.dp))
        Spacer(modifier = Modifier.height(16.dp))

        var header by remember { mutableStateOf("Select name") }

        NamePicker(
            header = header,
            names = SampleData.namesSample
        ) { selectedName ->
            header = "Selected name : $selectedName"
            showMessage(context, selectedName)
        }
    }
}

@Composable
fun NamePicker(
    header: String,
    names: List<String>,
    onNameClicked: (String) -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = header,
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.onSurface
        )
        Divider(modifier = Modifier.padding(all = 8.dp))
        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
            items(names) { name ->
                NamePickerItem(name = name, onClicked = onNameClicked)
            }
        }
    }
}

@Composable
fun NamePickerItem(name: String, onClicked: (String) -> Unit) {
    Text(
        text = name,
        color = MaterialTheme.colors.onSurface,
        modifier = Modifier.clickable(onClick = { onClicked(name) })
    )
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