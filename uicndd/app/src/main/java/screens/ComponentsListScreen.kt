package com.example.uicomponents.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ComponentsListScreen(navController: NavController) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("UI Components List", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = { navController.navigate("text") }, modifier = Modifier.fillMaxWidth()) {
            Text("Text")
        }
        Button(onClick = { navController.navigate("image") }, modifier = Modifier.fillMaxWidth()) {
            Text("Image")
        }
        Button(onClick = { navController.navigate("textfield") }, modifier = Modifier.fillMaxWidth()) {
            Text("TextField")
        }
        Button(onClick = { navController.navigate("row") }, modifier = Modifier.fillMaxWidth()) {
            Text("Row Layout")
        }
    }
}
