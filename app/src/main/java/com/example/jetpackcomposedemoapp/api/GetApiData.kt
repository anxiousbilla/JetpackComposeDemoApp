package com.example.jetpackcomposedemoapp.api

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.jetpackcomposedemoapp.Skeleton
import com.example.jetpackcomposedemoapp.navigation.Screen

@Composable
fun GetApiData(apiViewModel: ApiViewModel = viewModel(), navController: NavHostController) {
    val responseData by apiViewModel.responseData.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Skeleton(navController, "Get Api Data", Screen.StartScreen.route)
        Button(onClick = {
            apiViewModel.fetchData()
        }) {
            Text(text = "Fetch api data")
        }
        LazyColumn {
            items(responseData.size) { index ->
                ProductCard(responseData, index)
            }
        }
    }
}

@Composable
fun ProductCard(responseData: ApiData, index: Int) {
    Card(modifier = Modifier.padding(10.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.35f)
                    .background(Color.White)
                    .padding(10.dp), contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = responseData[index].image,
                    contentDescription = responseData[index].title,
                    contentScale = ContentScale.Fit
                )
            }
            Column(modifier = Modifier.padding(10.dp)) {
                Text(
                    modifier = Modifier.padding(bottom = 4.dp),
                    fontSize = 12.sp,
                    color = Color.Gray,
                    lineHeight = 20.sp,
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        ) {
                            append(responseData[index].title)
                        }
                        append("\n${responseData[index].category}")
                    }
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "$${responseData[index].price}")
                    Row {
                        Text(
                            fontSize = 14.sp,
                            text = "${responseData[index].rating.rate}"
                        )
                        Icon(
                            modifier = Modifier.height(20.dp),
                            tint = Color.Yellow,
                            imageVector = Icons.Filled.Star,
                            contentDescription = "Ratings icon"
                        )
                        Text(
                            fontSize = 14.sp,
                            text = "(${responseData[index].rating.count})"
                        )
                    }
                }
                Text(
                    fontSize = 12.sp,
                    text = responseData[index].description,
                    maxLines = 5,
                    lineHeight = 15.sp
                )
            }
        }
    }
}
