package xyz.uvarov.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint
import xyz.uvarov.composedemo.ui.detail.Detail
import xyz.uvarov.composedemo.ui.list.List
import xyz.uvarov.composedemo.ui.theme.ComposeDemoTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            ComposeDemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        floatingActionButton = {
                            FloatingActionButton(onClick = {}) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = null
                                )
                            }
                        },
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(text = "Compose demo")
                                }
                            )
                        }
                    ) { values ->
                        val rootNavController = rememberNavController()
                        NavHost(
                            navController = rootNavController,
                            startDestination = Screen.List.route,
                            modifier = Modifier.padding(values)
                        ) {
                            composable(Screen.List.route) {
                                List(hiltViewModel()) { id ->
                                    rootNavController.navigate(Screen.Detail.navigate(id))
                                }
                            }
                            composable(
                                Screen.Detail.route,
                                arguments = listOf(
                                    navArgument(Screen.Detail.id) {
                                        type = NavType.IntType
                                    }
                                )
                            ) {
                                Detail(hiltViewModel())
                            }
                        }
                    }
                }
            }
        }
    }
}
