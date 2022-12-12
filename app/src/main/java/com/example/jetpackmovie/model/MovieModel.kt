package com.example.jetpackmovie.model

// movie list api : https://www.howtodoandroid.com/apis/movielist.json

// data class according to JSON
data class MovieModel(
    val category : String ,
    val imageUrl : String ,
    val name : String ,
    val desc : String
)