package com.example.mycoffeeshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mycoffeeshop.ui.theme.MyCoffeeShopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCoffeeShopTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "Portada") {
                        composable("Portada") { Portada(navController) }
                        composable(
                            route = "Comentarios/{cafeteriaName}",
                            arguments = listOf(navArgument("cafeteriaName") { type = NavType.StringType })
                        ) { backStackEntry ->
                            Comentarios(backStackEntry.arguments?.getString("cafeteriaName") ?: "", navController)
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyCoffeeShopTheme {
    }
}