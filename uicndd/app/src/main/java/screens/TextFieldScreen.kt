package com.example.uicomponents.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldScreen() {
    var text by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Thông tin nhập") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "Tự động cập nhật dữ liệu theo textfield: $text",
            color = MaterialTheme.colorScheme.error
        )
    }
}
