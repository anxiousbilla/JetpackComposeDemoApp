package com.example.jetpackcomposedemoapp.api

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getData(): Response<ApiData>
}
