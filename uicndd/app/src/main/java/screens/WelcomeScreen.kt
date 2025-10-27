package com.example.uicomponents.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun WelcomeScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Jetpack Compose", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                "Jetpack Compose is a modern UI toolkit for building native Android applications."
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { navController.navigate("list") }) {
                Text("I'm ready")
            }
        }
    }
}
