package com.example.btvn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.btvn.ui.theme.BTVNTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BTVNTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UserInfoScreen()
                }
            }
        }
    }
}

@Composable
fun UserInfoScreen() {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var resultMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "THỰC HÀNH 01",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 32.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray.copy(alpha = 0.3f), shape = RoundedCornerShape(16.dp))
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = "Họ và tên", modifier = Modifier.width(80.dp))
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    modifier = Modifier.weight(1f),
                    singleLine = true,
                    label = { Text("Nhập họ tên") }
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = "Tuổi", modifier = Modifier.width(80.dp))
                OutlinedTextField(
                    value = age,
                    onValueChange = { age = it },
                    modifier = Modifier.weight(1f),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true,
                    label = { Text("Nhập tuổi") }
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                val ageInt: Int? = age.toIntOrNull()
                if (name.isBlank() || ageInt == null) {
                    resultMessage = "Vui lòng nhập đầy đủ và đúng thông tin."
                } else {
                    val ageCategory = when {
                        ageInt > 1000 -> "Quỷ"
                        ageInt > 150 -> "Ma Cà Rồng"
                        ageInt > 65 -> "Người già"
                        ageInt in 7..65 -> "Người lớn"
                        ageInt in 2..6 -> "Trẻ em"
                        ageInt >= 0 && ageInt < 2 -> "Em bé"
                        else -> "Tuổi không hợp lệ"
                    }
                    if (ageCategory == "Tuổi không hợp lệ") {
                        resultMessage = "Tuổi bạn nhập không hợp lệ."
                    } else {
                        resultMessage = "Thông tin của bạn: $name, $age tuổi, là $ageCategory."
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
                .height(50.dp)
        ) {
            Text(text = "Kiểm tra", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(32.dp))

        if (resultMessage.isNotEmpty()) {
            Text(
                text = resultMessage,
                fontSize = 18.sp,
                color = if (resultMessage.contains("hợp lệ")) Color.Red else MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 640)
@Composable
fun UserInfoScreenPreview() {
    BTVNTheme {
        UserInfoScreen()
    }
}
