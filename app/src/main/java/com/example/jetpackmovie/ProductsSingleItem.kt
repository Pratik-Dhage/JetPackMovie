package com.example.jetpackmovie

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.example.jetpackmovie.model.MovieModel
import com.example.jetpackmovie.model.Products_Model


// This is a Single Item of Product List

@Composable
fun ProductsSingleItem(product : Products_Model,index: Int, selectedIndex: Int, onClick: (Int) -> Unit) {

    val backgroundColor =
        if (index == selectedIndex) MaterialTheme.colors.primary else MaterialTheme.colors.background

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 4.dp)
            .height(110.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {

        Surface(color = backgroundColor) {

            Row (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp)
            ){

                //Product image
                Image(painter = rememberImagePainter(
                    data = product.image,
                    builder = {
                        scale(Scale.FILL)
                        placeholder(R.drawable.ic_launcher_background)
                        transformations(CircleCropTransformation())
                    }

                ),
                    contentDescription = product.description,
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(0.2f)

                )

                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(4.dp)
                        .weight(0.8f)

                ) {
                    //Product title
                    Text(text = product.title, style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold , maxLines = 1 , overflow = TextOverflow.Ellipsis)

                    //Product Price
                    Text(text = "$"+product.price.toString(), style = MaterialTheme.typography.subtitle2, fontWeight = FontWeight.Medium)


                    // Movie Category
                    Text(text = product.category, style = MaterialTheme.typography.caption,
                        modifier = Modifier
                            .padding(4.dp)
                            .background(
                                Color.Green
                            ))


                    // Product Description
                    Text(text = product.description, style = MaterialTheme.typography.body1,
                        maxLines = 2, overflow = TextOverflow.Ellipsis)
                }

            }

        }
    }
}

