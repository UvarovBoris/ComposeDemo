package xyz.uvarov.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import xyz.uvarov.composedemo.detail.Detail
import xyz.uvarov.composedemo.list.List
import xyz.uvarov.composedemo.ui.theme.ComposeDemoTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            ComposeDemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val rootNavController = rememberNavController()
                    NavHost(navController = rootNavController, startDestination = Screen.List.route) {
                        composable(Screen.List.route) {
                            List(hiltViewModel()) {
                                rootNavController.navigate(Screen.Detail.route)
                            }
                        }
                        composable(Screen.Detail.route) {
                            Detail(hiltViewModel())
                        }
                    }
                }
            }
        }
    }
}

sealed class Screen(val route: String) {
    object List : Screen("list")
    object Detail : Screen("detail")
}