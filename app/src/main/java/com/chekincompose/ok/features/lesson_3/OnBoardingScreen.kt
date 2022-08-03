package com.chekincompose.ok.features.lesson_3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chekincompose.ok.R

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingScreen(onNextClick: () -> Unit = {}) {

    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.onboarding_welcom)
            )
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = onNextClick
            ) {
                Text(stringResource(R.string.onboarding_go_next))
            }
        }
    }
}