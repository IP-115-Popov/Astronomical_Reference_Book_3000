package ru.sergey.astronomicalreferencebook3000.presentation

import android.opengl.GLSurfaceView
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState

import dagger.hilt.android.AndroidEntryPoint


import ru.sergey.astronomicalreferencebook3000.presentation.ViewModels.NewsViewModel
import ru.sergey.astronomicalreferencebook3000.presentation.screens.AstronomicalScreen
import ru.sergey.astronomicalreferencebook3000.presentation.screens.NewsScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val vm : NewsViewModel by viewModels()
    private lateinit var gLView: GLSurfaceView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)



        setContent {
            Main(vm)
        }
    }
}
@Composable
fun Main(vm : NewsViewModel) {
    val navController = rememberNavController()
    Column {
        NavHost(
            navController = navController,
            startDestination  = NavRoutes.AstronomicalScreen.route,
            modifier = Modifier.fillMaxHeight(0.9f)) {
            composable(NavRoutes.NewsScreen.route) { NewsScreen(vm) }
            composable(NavRoutes.AstronomicalScreen.route) { AstronomicalScreen() }
        }
        BottomNavigationBar(navController = navController, modifier = Modifier.fillMaxHeight())
    }
}
@Composable
fun BottomNavigationBar(navController: NavController, modifier: Modifier = Modifier) {
    NavigationBar(modifier) {
        val backStackEntry = navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry.value?.destination?.route

        NavBarItems.BarItems.forEach { navItem ->
            NavigationBarItem(
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {saveState = true}
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(imageVector = navItem.image,
                        contentDescription = navItem.title)
                },
                label = {
                    Text(text = navItem.title)
                }
            )
        }
    }
}
data class BarItem(
    val title: String,
    val image: ImageVector,
    val route: String
)
object NavBarItems {
    val BarItems = listOf(
        BarItem(
            title = "NewsScreen",
            image = Icons.Filled.Home,
            route = "NewsScreen"
        ),
        BarItem(
            title = "AstronomicalScreen",
            image = Icons.Filled.PlayArrow,
            route = "AstronomicalScreen"
        ),

        )
}
sealed class NavRoutes(val route: String) {
    object NewsScreen : NavRoutes("NewsScreen")
    object AstronomicalScreen : NavRoutes("AstronomicalScreen")
}
