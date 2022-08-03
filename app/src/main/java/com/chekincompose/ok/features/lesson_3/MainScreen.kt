package com.chekincompose.ok.features.lesson_3

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chekincompose.ok.R
import com.chekincompose.ok.models.SampleData

@Preview
@Composable
fun MainScreen(names: List<String> = SampleData.namesSample) {
    Surface {
        LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
            items(items = names) { name ->
                InfoCards(name)
            }
        }
    }
}

@Composable
fun InfoCards(name: String) {
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        CardContent(name = name)
    }
}

@Composable
fun CardContent(name: String) {
    var isExpanded by rememberSaveable { mutableStateOf(false) }

    /*val extraPadding by animateDpAsState(
        targetValue = if (isExpanded) 48.dp else 0.dp,
        animationSpec = repeatable(
            iterations = 5,
            animation = tween(durationMillis = 600),
            repeatMode = RepeatMode.Reverse
        )
    )
*/

    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(text = stringResource(R.string.main_screen_hello))
            Text(
                text = name, style = MaterialTheme.typography.caption.copy(
                    fontWeight = FontWeight.ExtraBold
                )
            )
            if (isExpanded) {
                Text(
                    text = "Composem ipsum color sit lazy, " +
                            "padding theme elit, sed do bouncy. ".repeat(4)
                )
            }
        }
        IconButton(onClick = { isExpanded = !isExpanded }) {
            Icon(
                imageVector = if (isExpanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = if (isExpanded) {
                    stringResource(id = R.string.show_less)
                } else {
                    stringResource(id = R.string.show_more)
                }
            )
        }
    }
}