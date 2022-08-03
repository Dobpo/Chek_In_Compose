package com.chekincompose.ok.features.lesson_3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chekincompose.ok.models.SampleData

@Preview
@Composable
fun MainScreen(names: List<String> = SampleData.namesSample) {
    Column(modifier = Modifier.padding(vertical = 4.dp)) {
        for (name in names) {
            InfoCard(name)
        }
    }
}

@Composable
fun InfoCard(name: String) {
    var isExpanded by remember { mutableStateOf(false) }
    val extraPadding = if (isExpanded) 48.dp else 0.dp

    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = extraPadding)
            ) {
                Text(text = "Hello, ")
                Text(text = name)
            }
            OutlinedButton(onClick = { isExpanded = !isExpanded }) {
                Text(if (isExpanded) "Show less" else "Show more")
            }
        }
    }
}