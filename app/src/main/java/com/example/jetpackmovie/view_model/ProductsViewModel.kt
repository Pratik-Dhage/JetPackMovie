package com.example.jetpackmovie.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackmovie.apiService.ApiService
import com.example.jetpackmovie.model.Products_Model
import kotlinx.coroutines.launch

class ProductsViewModel : ViewModel() {

    var productsListResponse : List<Products_Model> by mutableStateOf(listOf())
    var errorResponse : String by mutableStateOf("")


    fun getProductsList(){

        viewModelScope.launch {

            val apiService = ApiService.getInstance()

             try{
                 productsListResponse = apiService.getProducts()
             }
             catch(e: Exception)
             {
                 errorResponse = e.message.toString()
                 print("here "+ (e.localizedMessage?.toString() ?: ""))
             }

        }

    }


}