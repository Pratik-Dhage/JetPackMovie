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


// This is a Single Item of MovieList

@Composable
fun MovieSingleItem(movie : MovieModel,index: Int, selectedIndex: Int, onClick: (Int) -> Unit) {

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

                Image(painter = rememberImagePainter(
                    data = movie.imageUrl,
                    builder = {
                        scale(Scale.FILL)
                       placeholder(R.drawable.ic_launcher_background)
                        transformations(CircleCropTransformation())
                    }

                ),
                    contentDescription = movie.desc,
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
                    //Movie Name
                    Text(text = movie.name, style = MaterialTheme.typography.subtitle1, fontWeight = FontWeight.Bold)

                  // Movie Category
                    Text(text = movie.category, style = MaterialTheme.typography.caption,
                        modifier = Modifier
                        .padding(4.dp)
                        .background(
                            Color.Gray
                        ))

                    // Movie Description
                    Text(text = movie.desc, style = MaterialTheme.typography.body1,
                        maxLines = 2, overflow = TextOverflow.Ellipsis)
                }

            }
            
        }
    }
}

