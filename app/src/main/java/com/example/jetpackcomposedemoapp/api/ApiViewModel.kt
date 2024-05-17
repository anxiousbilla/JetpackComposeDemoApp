package com.example.jetpackcomposedemoapp.api

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.Response

class ApiViewModel: ViewModel() {
    private lateinit var response: Response<ApiData>
    private var _responseData = MutableStateFlow(ApiData())
    var responseData: StateFlow<ApiData> = _responseData.asStateFlow()

    fun fetchData() {
        viewModelScope.launch {
            response = ApiClient.apiService.getData()
            response.body()?.let {response ->
                _responseData.update { response }
            }
        }
    }
}
