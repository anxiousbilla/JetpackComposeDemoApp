package com.example.jetpackcomposedemoapp.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposedemoapp.BottomNavigationBarScreen
import com.example.jetpackcomposedemoapp.CircularProgressBarScreen
import com.example.jetpackcomposedemoapp.DetailsScreen
import com.example.jetpackcomposedemoapp.ImageCardScreen
import com.example.jetpackcomposedemoapp.LazyColumn
import com.example.jetpackcomposedemoapp.MainScreen
import com.example.jetpackcomposedemoapp.MessageCardAndConversationScreen
import com.example.jetpackcomposedemoapp.MultiSelectLazyColumn
import com.example.jetpackcomposedemoapp.MyConstraintLayout
import com.example.jetpackcomposedemoapp.PermissionsHandling
import com.example.jetpackcomposedemoapp.ProfileHeaderAnimationScreen
import com.example.jetpackcomposedemoapp.RememberWindowInfoLazyColumnScreen
import com.example.jetpackcomposedemoapp.ScrollableColumn
import com.example.jetpackcomposedemoapp.StartScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    androidx.navigation.compose.NavHost(
        navController = navController,
        startDestination = Screen.StartScreen.route
    ) {
        composable(route = Screen.StartScreen.route) {
            StartScreen(navController)
        }
        composable(route = Screen.LazyColumnScreen.route) {
            LazyColumn(navController)
        }
        composable(route = Screen.ScrollableColumnScreen.route) {
            ScrollableColumn(navController)
        }
        composable(route = Screen.MessageCardAndConversationScreen.route) {
            MessageCardAndConversationScreen(navController)
        }
        composable(route = Screen.ConstraintLayoutScreen.route) {
            MyConstraintLayout(navController)
        }
        composable(route = Screen.MultiSelectLazyColumnScreen.route) {
            MultiSelectLazyColumn(navController)
        }
        composable(route = Screen.PermissionsHandlingScreen.route) {
            PermissionsHandling(navController)
        }
        composable(route = Screen.RememberWindowInfoLazyColumnScreen.route) {
            RememberWindowInfoLazyColumnScreen(navController)
        }
        composable(route = Screen.ProfileHeaderAnimationScreen.route) {
            ProfileHeaderAnimationScreen(navController)
        }
        composable(route = Screen.ImageCardScreen.route) {
            ImageCardScreen(navController)
        }
        composable(route = Screen.CircularProgressBarScreen.route) {
            CircularProgressBarScreen(navController)
        }
        composable(route = Screen.BottomNavigationBarScreen.route) {
            BottomNavigationBarScreen(navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(
            route = Screen.DetailsScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Tom"
                    nullable = true
                }
            )
        ) { entry ->
            DetailsScreen(name = entry.arguments?.getString("name"))
        }
    }
}