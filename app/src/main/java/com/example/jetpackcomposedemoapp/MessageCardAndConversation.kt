package com.example.jetpackcomposedemoapp

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposedemoapp.data.SampleData
import com.example.jetpackcomposedemoapp.ui.theme.JetpackComposeDemoAppTheme
import kotlin.random.Random

data class Message(val text: String, val author: String)

@Composable
fun MessageCard(msg: Message) {
    val color = remember { mutableStateOf(Color.Transparent) }

    Row(
        modifier = Modifier.padding(all = 8.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(color.value)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
                .clickable {
                    color.value = Color(
                        Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), 1f
                    )
                })

        Spacer(modifier = Modifier.width(8.dp))

        var isExpanded by remember { mutableStateOf(false) }

        Column(modifier = Modifier
            .background(color.value)
            .padding(all = 10.dp)
            .clickable { isExpanded = !isExpanded }) {
            Text(
                text = msg.text,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )

            Spacer(modifier = Modifier.height(8.dp))

            Surface(
                shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp
            ) {
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = msg.author,
                    color = MaterialTheme.colorScheme.tertiary,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1
                )
            }
        }
    }
}

@Preview(
    name = "Light mode", showBackground = true
)
@Composable
private fun PreviewMessageCardLight() {
    JetpackComposeDemoAppTheme {
        Surface {
            MessageCard(Message("Jetpack Compose", "Android"))
        }
    }
}

@Preview(
    name = "Dark mode", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun PreviewMessageCardDark() {
    JetpackComposeDemoAppTheme {
        Surface {
            MessageCard(Message("Jetpack Compose", "Android"))
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    androidx.compose.foundation.lazy.LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    Conversation(SampleData.conversationSample)
}