package com.example.jetpackmovie.apiService

import com.example.jetpackmovie.model.MovieModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    //end point : movielist.json
    @GET("movielist.json")
      suspend fun getMovies() : List<MovieModel>

      companion object{

          var apiService : ApiService? = null
          fun getInstance() : ApiService {

              if (apiService==null){

                  // movie list api : https://www.howtodoandroid.com/apis/movielist.json

                  apiService = Retrofit.Builder()
                      .baseUrl("https://www.howtodoandroid.com/apis/")
                      .addConverterFactory(GsonConverterFactory.create())
                      .build().create(ApiService::class.java)
              }
                  return apiService!!
          }
      }
}