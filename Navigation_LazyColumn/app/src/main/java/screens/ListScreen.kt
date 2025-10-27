import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("LazyColumn") })
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            // Tạo 20 mục trong danh sách
            items(20) { index ->
                ListItem(
                    headlineContent = { Text("Mục số ${index + 1}") },
                    modifier = Modifier.clickable {
                        // Chuyển tới màn hình chi tiết
                        // Bạn có thể truyền ID của mục nếu cần, ví dụ: navController.navigate("detail/${index + 1}")
                        navController.navigate("detail")
                    }
                )
                Divider()
            }
        }
    }
}