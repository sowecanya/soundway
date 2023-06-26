package com.example.soundway

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.soundway.ui.theme.SoundwayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SoundwayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
    ) {
        items(100) { position ->

            println("Build item at position $position")

            Row {
                MyListItem(
                    position = position,
                    color = Color.White,
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun MyListItem(
    position: Int = 0,
    color: Color = Color.Black
) {
    Box(
        modifier = Modifier
            .aspectRatio(5f)
            .padding(4.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(Color.Gray)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(fraction = 0.9f)
                .padding(4.dp)
                .height(62.dp)
        ) {
            Box(
                modifier = Modifier
                    .aspectRatio(1.0f, matchHeightConstraintsFirst = true)
                    .clip(CircleShape)
                    .background(color)
            ) {
                Text(
                    text = position.toString(),
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.width(6.dp))

            Column(
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(12.dp)
                        .clip(shape = RoundedCornerShape(2.dp))
                        .background(color)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth(fraction = 0.6f)
                        .height(8.dp)
                        .clip(shape = RoundedCornerShape(2.dp))
                        .background(color)
                )
            }
        }
    }
}
