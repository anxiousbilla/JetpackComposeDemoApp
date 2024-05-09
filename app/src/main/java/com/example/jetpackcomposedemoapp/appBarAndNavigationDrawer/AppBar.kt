package com.example.jetpackcomposedemoapp.appBarAndNavigationDrawer

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.jetpackcomposedemoapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(onNavigationItemClick: () -> Unit) {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.app_name)) },
        navigationIcon = {
            IconButton(onClick = onNavigationItemClick) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "toggle drawer")
            }
        }
    )
}