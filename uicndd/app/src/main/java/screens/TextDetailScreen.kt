package com.example.uicomponents.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TextDetailScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("The ", style = MaterialTheme.typography.bodyLarge)
        Text("quick ", style = MaterialTheme.typography.bodyLarge.copy(textDecoration = null))
        Text("Brown", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
        Text(" fox jumps ", fontStyle = FontStyle.Italic)
        Text("over the lazy dog.", style = MaterialTheme.typography.bodyLarge)
    }
}
