package com.example.jetpackmovie.view_model

import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackmovie.MainActivity
import com.example.jetpackmovie.apiService.ApiService
import com.example.jetpackmovie.model.MovieModel
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var movieListResponse: List<MovieModel> by mutableStateOf(listOf())
    var errorResponse: String by mutableStateOf("")

    fun getMoviesList() {

        //viewModel Scope means as long ViewModel Lives Statements inside it will live

        viewModelScope.launch {

            val apiService = ApiService.getInstance()

            try {
                movieListResponse = apiService.getMovies() // fill response with getMovies i.e List<MovieModel>
            }
            catch (e: Exception) {
                errorResponse = e.message.toString()
               print("here "+ (e.localizedMessage?.toString() ?: ""))
            }

        }

    }
}