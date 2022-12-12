package com.example.jetpackmovie

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.example.jetpackmovie.ui.theme.JetPackMovieTheme
import com.example.jetpackmovie.view_model.MainViewModel
import com.example.jetpackmovie.view_model.ProductsViewModel

class MainActivity : ComponentActivity() {

    val mainViewModel by viewModels<MainViewModel>() // for Movie List
    val productViewModel by viewModels<ProductsViewModel>() // for Product List

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackMovieTheme {


                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Yellow
                ){


                  /*  MovieList(movieList = mainViewModel.movieListResponse)
                    mainViewModel.getMoviesList()
*/

                    ProductList(productList = productViewModel.productsListResponse)
                    productViewModel.getProductsList()
                }
            }
        }
    }
}



