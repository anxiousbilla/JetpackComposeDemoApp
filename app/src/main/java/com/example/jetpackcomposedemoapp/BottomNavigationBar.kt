package com.example.jetpackcomposedemoapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class Screens {
    object Home : Screen("Home")
    object Chat : Screen("Chat")
    object Settings : Screen("Settings")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBars() {
    val items = listOf(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false
        ),
        BottomNavigationItem(
            title = "Chat",
            selectedIcon = Icons.Filled.Email,
            unselectedIcon = Icons.Outlined.Email,
            hasNews = false,
            badgeCount = 20
        ),
        BottomNavigationItem(
            title = "Settings",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            hasNews = true
        ),
    )
    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                            if (item.title == "Home") navController.navigate(Screens.Home.route)
                            if (item.title == "Chat") navController.navigate(Screens.Chat.route)
                            if (item.title == "Settings") navController.navigate(Screens.Settings.route)
                        },
                        label = { Text(text = item.title) },
                        icon = {
                            BadgedBox(
                                badge = {
                                    if (item.badgeCount != null) {
                                        Badge {
                                            Text(text = item.badgeCount.toString())
                                        }
                                    } else if (item.hasNews) {
                                        Badge()
                                    }
                                }) {
                                Icon(
                                    imageVector = if (index == selectedItemIndex) {
                                        item.selectedIcon
                                    } else {
                                        item.unselectedIcon
                                    },
                                    contentDescription = item.title
                                )
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        BottomNavigationBar(navController)
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    androidx.navigation.compose.NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    ) {
        composable(Screens.Home.route) {
            HomeScreen()
        }
        composable(Screens.Chat.route) {
            ChatScreen()
        }
        composable(Screens.Settings.route) {
            SettingsScreen()
        }
    }
}

@Composable
fun HomeScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Home Screen")
    }
}

@Composable
fun ChatScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Chat Screen")
    }
}

@Composable
fun SettingsScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Settings Screen")
    }
}