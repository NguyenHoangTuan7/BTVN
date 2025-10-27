import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    // Tạo một NavController để quản lý việc điều hướng
    val navController = rememberNavController()

    // NavHost là container chứa các màn hình của bạn
    NavHost(navController = navController, startDestination = "root") {
        // Định nghĩa các route (đường dẫn) tới các màn hình
        composable(route = "root") {
            RootScreen(navController = navController)
        }
        composable(route = "list") {
            ListScreen(navController = navController)
        }
        composable(route = "detail") {
            DetailScreen(navController = navController)
        }
    }
}