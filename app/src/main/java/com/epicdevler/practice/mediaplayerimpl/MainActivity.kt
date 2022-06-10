package com.epicdevler.practice.mediaplayerimpl

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.epicdevler.practice.mediaplayerimpl.ui.theme.MediaPlayerImplTheme
import com.epicdevler.practice.mediaplayerimpl.utils.MediaHandler
import com.google.android.exoplayer2.ExoPlayer

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val str = "https://storage.googleapis.com/exoplayer-test-media-0/play.mp3"
        setContent {
            MediaPlayerImplTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Player()
                }
            }
        }
    }
}

@Composable
fun Player() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val context = LocalContext.current
        var isPlaying by remember { mutableStateOf(false) }
        val player by remember {
            mutableStateOf(ExoPlayer.Builder(context).build())
        }

//        val player = MediaHandler(context)
        val playerManager = MediaHandler(player = player)
        playerManager.initDefault()
        Button(
            onClick = {
                playerManager.startPlayer()
                isPlaying = true
            },
            enabled = !isPlaying
        ) { Text(text = "Play") }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                playerManager.pausePlayer()
                isPlaying = false
            },
            enabled = isPlaying
        ) {
            Text(text = "Pause")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                playerManager.stopPlayer()
                isPlaying = false
            },
            enabled = isPlaying
        ) {
            Text(text = "Stop")
        }

        Button(
            onClick = {
                playerManager.skip(10)
            },
            enabled = isPlaying
        ) {
            Text(text = ">> 10")
        }

        Button(
            onClick = {
                playerManager.skip(-10)
            },
            enabled = isPlaying
        ) {
            Text(text = "<< 10")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    MediaPlayerImplTheme {
        Player()
    }
}