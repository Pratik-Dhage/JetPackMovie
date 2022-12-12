package com.example.jetpackmovie.apiService

import com.example.jetpackmovie.model.MovieModel
import com.example.jetpackmovie.model.Products_Model
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    // for Movie List
    //end point : movielist.json
    @GET("movielist.json")
      suspend fun getMovies() : List<MovieModel>

      //for Products List
      //end point : products
      @GET("/products")
      suspend fun getProducts() : List<Products_Model>

      companion object{

          var apiService : ApiService? = null
          fun getInstance() : ApiService {

              if (apiService==null){

                  // movie list api : https://www.howtodoandroid.com/apis/movielist.json
                  // product list api : https://fakestoreapi.com/products

                  apiService = Retrofit.Builder()
                    // .baseUrl("https://www.howtodoandroid.com/apis/")
                    .baseUrl("https://fakestoreapi.com")
                      .addConverterFactory(GsonConverterFactory.create())
                      .build().create(ApiService::class.java)
              }
                  return apiService!!
          }
      }



}