package com.example.tutorial_janken

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tutorial_janken.ui.theme.TutorialjankenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TutorialjankenTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   Content()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun PlayerView(hand: Int) {
    when (hand) {
        0 -> Image(
            painterResource(id = R.drawable.gu),
            contentDescription = null
        )
        1 -> Image(
            painterResource(id = R.drawable.choki),
            contentDescription = null
        )
        2 -> Image(
            painterResource(id = R.drawable.pa),
            contentDescription = null
        )
    }
}

@Composable
fun ResultView(result: Int) {
    when (result) {
        0 -> Text(text = "draw")
        1 -> Text(text = "win")
        2 -> Text(text = "lose")
    }
}

@Composable
fun ComputerView(comHand: Int) {
    when (comHand) {
        0 -> Image(
            painterResource(id = R.drawable.com_gu),
            contentDescription = null
        )
        1 -> Image(
            painterResource(id = R.drawable.com_choki),
            contentDescription = null
        )
        2 -> Image(
            painterResource(id = R.drawable.com_pa),
            contentDescription = null
        )
    }
}

@Composable
fun Content() {
    var myHand by remember { mutableStateOf(-1) }
    var comHand by remember { mutableStateOf(-1) }
    var result by remember { mutableStateOf(-1) }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("janken app")
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(onClick = {
                myHand = 0
                comHand = (0..2).random()
                result = (comHand - myHand) + 3 % 3
            }) {
                Text("Gu")
            }
            Button(onClick = {
                myHand = 1
                comHand = (0..2).random()
                result = (comHand - myHand) + 3 % 3
            }) {
                Text("Choki")
            }
            Button(onClick = {
                myHand = 2
                comHand = (0..2).random()
                result = (comHand - myHand) + 3 % 3
            }) {
                Text("Pa")
            }
        }
    }
    PlayerView(hand = myHand)
    ResultView(result = result)
    ComputerView(comHand = comHand)
}

@Preview
@Composable
fun PlayerViewPreview() {
    PlayerView(hand = 0)
}

@Preview(showBackground = true)
@Composable
fun ResultViewPreview() {
    ResultView(result = 1)
}

@Preview
@Composable
fun ComtuperViewPreview() {
    ComputerView(comHand = 1)
}

@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    Content()
}