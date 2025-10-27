package com.example.uicomponents

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.uicomponents.screens.*

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "welcome") {
        composable("welcome") { WelcomeScreen(navController) }
        composable("list") { ComponentsListScreen(navController) }
        composable("text") { TextDetailScreen() }
        composable("image") { ImageDetailScreen() }
        composable("textfield") { TextFieldScreen() }
        composable("row") { RowLayoutScreen() }
    }
}
