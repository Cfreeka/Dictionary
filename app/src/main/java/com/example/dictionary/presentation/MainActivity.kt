package com.example.dictionary.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.dictionary.R
import com.example.dictionary.ui.theme.DictionaryTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DictionaryTheme {
                BarColors()
                val viewModel = hiltViewModel<MainViewModel>()
                val mainState by viewModel.mainState.collectAsState()

                Scaffold(

                    topBar = {
                        CenterAlignedTopAppBar(
                            title = {
                                Text(
                                    text = getString(R.string.app_name),
                                    color = MaterialTheme.colorScheme.primary,
                                    fontSize = 30.sp,
                                    fontWeight = FontWeight.SemiBold
                                )
                            },

                        )

                    }) { paddingValues ->


                    MainScreen(
                        modifier = Modifier.padding(paddingValues),
                        mainState = mainState,
                        onSearchWordChange = {
                            viewModel.onEvent(
                                MainUiEvents.OnSearchWordChange(
                                    it
                                )
                            )
                        },
                        onSearchClick = {
                            viewModel.onEvent(MainUiEvents.OnSearchClick)
                        }

                    )

                }

            }
        }
    }


    @Composable
    private fun BarColors() {
        val systemUiController = rememberSystemUiController()
        val color = MaterialTheme.colorScheme.background

        LaunchedEffect(color) {
            systemUiController.setSystemBarsColor(color)
        }
    }
}





















