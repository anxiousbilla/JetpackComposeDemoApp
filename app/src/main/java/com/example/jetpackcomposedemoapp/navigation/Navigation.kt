package com.example.jetpackcomposedemoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposedemoapp.AnimatedCounterScreen
import com.example.jetpackcomposedemoapp.BottomNavigationBarScreen
import com.example.jetpackcomposedemoapp.BottomSheetScreen
import com.example.jetpackcomposedemoapp.CircularProgressBarScreen
import com.example.jetpackcomposedemoapp.DetailsScreen
import com.example.jetpackcomposedemoapp.ImageCardScreen
import com.example.jetpackcomposedemoapp.LazyColumn
import com.example.jetpackcomposedemoapp.LazyGrid
import com.example.jetpackcomposedemoapp.MainScreen
import com.example.jetpackcomposedemoapp.MessageCardAndConversationScreen
import com.example.jetpackcomposedemoapp.MultiSelectLazyColumn
import com.example.jetpackcomposedemoapp.MyConstraintLayout
import com.example.jetpackcomposedemoapp.PermissionsHandling
import com.example.jetpackcomposedemoapp.ProfileHeaderAnimationScreen
import com.example.jetpackcomposedemoapp.RememberWindowInfoLazyColumnScreen
import com.example.jetpackcomposedemoapp.ScrollableColumn
import com.example.jetpackcomposedemoapp.StartScreen
import com.example.jetpackcomposedemoapp.TopAppBar

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
            DetailsScreen(navController, name = entry.arguments?.getString("name"))
        }
        composable(route = Screen.AnimatedCounterScreen.route) {
            AnimatedCounterScreen(navController)
        }
        composable(route = Screen.LazyGridScreen.route) {
            LazyGrid(navController)
        }
        composable(route = Screen.TopAppBarScreen.route) {
            TopAppBar(navController)
        }
        composable(route = Screen.BottomSheetScreen.route) {
            BottomSheetScreen()
        }
    }
}