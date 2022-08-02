package com.chekincompose.ok

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chekincompose.ok.models.Message

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard(Message("Hello ", "Compose"))
        }
    }
}

@Composable
fun MessageCard(message: Message) {
    Row {
        Image(
            painter = painterResource(id = R.drawable.img_profile),
            contentDescription = "Contact profile image",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(message.author)
            Text(message.body)
        }
    }
}

@Preview
@Composable
fun PreviewMessage() {
    MessageCard(Message("Hello ", "Compose"))
}