package com.example.jetpackmovie

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.*
import com.example.jetpackmovie.model.Products_Model

@Composable
fun ProductList(productList : List<Products_Model>) {

    var selectedIndex by remember { mutableStateOf(-1) }
    //Acts as RecyclerView
    LazyColumn {
        itemsIndexed(items = productList){
                index, item ->  ProductsSingleItem(product = item, index , selectedIndex){
                i ->  selectedIndex = i
        }
        }

    }
}