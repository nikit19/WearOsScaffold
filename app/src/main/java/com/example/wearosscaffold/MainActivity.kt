package com.example.wearosscaffold

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.*

class MainActivity : ComponentActivity() {
    @ExperimentalWearMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                val scalingLazyListState: ScalingLazyListState = rememberScalingLazyListState()

                Scaffold(
                    timeText = {
                        TimeText()
                    },
                    vignette = {
                        Vignette(vignettePosition = VignettePosition.TopAndBottom)
                    },
                    positionIndicator = {
                        PositionIndicator(
                            scalingLazyListState = scalingLazyListState
                        )

                    }
                ) {
                    ScalingLazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(
                            top = 28.dp,
                            start = 10.dp,
                            end = 10.dp,
                            bottom = 40.dp
                        ),
                        verticalArrangement = Arrangement.Center,
                        state = scalingLazyListState
                    ) {
                        items(10) { index ->
                            Chip(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 10.dp),
                                icon = {
                                    Icon(
                                        painter = painterResource(id = android.R.drawable.btn_star_big_on),
                                        contentDescription = "Star",
                                        modifier = Modifier
                                            .size(24.dp)
                                            .wrapContentSize(align = Alignment.Center),
                                    )
                                },
                                label = {
                                    Text(
                                        modifier = Modifier.fillMaxWidth(),
                                        color = MaterialTheme.colors.onPrimary,
                                        text = "Item ${index + 1}"
                                    )
                                },
                                onClick = {
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
