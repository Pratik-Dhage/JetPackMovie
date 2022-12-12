package com.example.jetpackmovie

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.example.jetpackmovie.model.MovieModel
import com.example.jetpackmovie.view_model.MainViewModel


@Composable
fun MovieList(movieList : List<MovieModel> ) {

    var selectedIndex by remember { mutableStateOf(-1) }
    //Acts as RecyclerView
    LazyColumn {
        itemsIndexed(items = movieList){
            index, item ->  MovieSingleItem(movie = item, index , selectedIndex){
              i ->  selectedIndex = i
        }
        }

    }
}

/*
@Preview
@Composable
fun ComposablePreview() {
    val mainViewModel = MainViewModel()
    MovieList(movieList = mainViewModel.movieListResponse)
    mainViewModel.getMoviesList()
   // MovieSingleItem(movie = item, index , selectedIndex)
}
*/
