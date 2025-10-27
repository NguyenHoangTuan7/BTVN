import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun RootScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Bạn có thể thêm Icon và Text giống trong hình ở đây
        Text(text = "Màn hình chính")
        Button(onClick = {
            // Chuyển tới màn hình danh sách
            navController.navigate("list")
        }) {
            Text("PUSH (Đi tới danh sách)")
        }
    }
}