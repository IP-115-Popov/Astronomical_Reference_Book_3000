package ru.sergey.astronomicalreferencebook3000.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import ru.sergey.astronomicalreferencebook3000.presentation.screens.NewsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Main()
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Main() {
    val navController = rememberNavController()
    Column {
        NavHost(navController = navController, startDestination  = NavRoutes.NewsScreen.route) {
            composable(NavRoutes.NewsScreen.route) { NewsScreen() }
        }
    }
}

sealed class NavRoutes(val route: String) {
    object NewsScreen : NavRoutes("NewsScreen")
}
