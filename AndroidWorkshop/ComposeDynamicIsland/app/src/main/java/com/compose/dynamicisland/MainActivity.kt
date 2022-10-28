package com.compose.dynamicisland

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.compose.dynamicisland.ui.theme.ComposeDynamicIslandTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDynamicIslandTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    var state: IslandType by remember {
                        mutableStateOf(IslandType.Small)
                    }

                    Column(
                        Modifier.padding(top = 10.dp, bottom = 50.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween,
                    ) {
                        DynamicIsland(state)

                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Button(onClick = { state = IslandType.Small }) {
                                Text("Small")
                            }
                            Button(onClick = { state = IslandType.Medium }) {
                                Text("Medium")
                            }
                            Button(onClick = { state = IslandType.Large }) {
                                Text("Large")
                            }
                        }

                    }


                }
            }
        }
    }
}
