package com.example.qltv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.librarymanager.data.Book
import com.example.librarymanager.data.Student

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LibraryApp()
        }
    }
}

@Composable
fun LibraryApp() {
    var students by remember {
        mutableStateOf(
            listOf(
                Student("Nguyen Van A", mutableListOf(Book("Sách 01"), Book("Sách 02"))),
                Student("Nguyen Thi B", mutableListOf(Book("Sách 01"))),
                Student("Nguyen Van C", mutableListOf())
            )
        )
    }

    var currentStudentIndex by remember { mutableStateOf(0) }
    val currentStudent = students[currentStudentIndex]

    Scaffold(
        bottomBar = {
            BottomNavigationBar()
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            Text(
                "Hệ thống Quản lý Thư viện",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(Modifier.height(16.dp))

            // Nhập tên sinh viên
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedTextField(
                    value = currentStudent.name,
                    onValueChange = {},
                    label = { Text("Sinh viên") },
                    modifier = Modifier.weight(1f)
                )
                Spacer(Modifier.width(8.dp))
                Button(onClick = {
                    currentStudentIndex =
                        (currentStudentIndex + 1) % students.size // Chuyển sinh viên khác
                }) {
                    Text("Thay đổi")
                }
            }

            Spacer(Modifier.height(16.dp))
            Text("Danh sách sách", fontWeight = FontWeight.Medium)

            if (currentStudent.books.isEmpty()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(Color(0xFFEFEFEF)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Bạn chưa mượn quyển sách nào\nNhấn 'Thêm' để bắt đầu hành trình đọc sách!",
                        color = Color.DarkGray
                    )
                }
            } else {
                LazyColumn {
                    items(currentStudent.books) { book ->
                        BookItem(book)
                    }
                }
            }

            Spacer(Modifier.height(16.dp))
            Button(
                onClick = {
                    val newBook = Book("Sách 0" + (currentStudent.books.size + 1))
                    currentStudent.books.add(newBook)
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Thêm")
            }
        }
    }
}

@Composable
fun BookItem(book: Book) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF8F8F8))
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(checked = true, onCheckedChange = {})
            Spacer(Modifier.width(8.dp))
            Text(book.title)
        }
    }
}

@Composable
fun BottomNavigationBar() {
    NavigationBar {
        NavigationBarItem(
            selected = true,
            onClick = {},
            label = { Text("Quản lý") },
            icon = {}
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            label = { Text("DS Sách") },
            icon = {}
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            label = { Text("Sinh viên") },
            icon = {}
        )
    }
}
