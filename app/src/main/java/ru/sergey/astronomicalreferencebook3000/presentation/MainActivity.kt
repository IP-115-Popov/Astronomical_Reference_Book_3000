package ru.sergey.astronomicalreferencebook3000.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable

import dagger.hilt.android.AndroidEntryPoint

import ru.sergey.astronomicalreferencebook3000.presentation.ViewModels.NewsViewModel
import ru.sergey.astronomicalreferencebook3000.presentation.screens.NewsScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val vm : NewsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Main(vm)
        }
    }
}

@Composable
fun Main(vm : NewsViewModel) {
    val navController = rememberNavController()
    Column {
        NavHost(navController = navController, startDestination  = NavRoutes.NewsScreen.route) {
            composable(NavRoutes.NewsScreen.route) { NewsScreen(vm) }
        }
    }
}

sealed class NavRoutes(val route: String) {
    object NewsScreen : NavRoutes("NewsScreen")
}
