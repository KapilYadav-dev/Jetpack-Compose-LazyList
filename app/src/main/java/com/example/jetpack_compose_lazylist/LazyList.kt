package com.example.jetpack_compose_lazylist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CustomLazyColumn() {
    LazyColumn() {
        val list = listOf(Profile("John", "Doe"), Profile("Jane", "Doe"), Profile("Jack", "Doe"))
        items(list) { item ->
            ProfileUI(item)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CustomLazyRow() {
    LazyRow() {
        val list = listOf(Profile("John", "Doe"), Profile("Jane", "Doe"), Profile("Jack", "Doe"))
        items(list) { item ->
            ProfileUI(item)
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CustomLazyVerticalGrid() {
    val list = listOf(
        Profile("John", "Doe"), Profile("Jane", "Doe"), Profile("Jack", "Doe"),
        Profile("John", "Doe"), Profile("Jane", "Doe"), Profile("Jack", "Doe"),
        Profile("John", "Doe"), Profile("Jane", "Doe"), Profile("Jack", "Doe")
    )
    LazyVerticalGrid(
        /*
         * cells = GridCells.fixed(2) is used to
         * specify that the grid will have 2 columns.
         *
         * cells = GridCells.Fixed(2)
         */

        /**
         * Combines cells with adaptive number of rows or columns. It will try to position as many rows
         * or columns as possible on the condition that every cell has at least [minSize] space and
         * all extra space distributed evenly.
         */
        cells = GridCells.Adaptive(128.dp)
    ) {
        items(list) { person ->
            ProfileUI(person)
        }
    }
}


@Composable
fun ProfileUI(item: Profile) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(2.dp, Color.Black)
            .padding(16.dp)
    ) {
        Text(text = "First name : ${item.firstName}")
        Text(text = "Second name : ${item.lastName}")
    }
}

data class Profile(
    val firstName: String,
    val lastName: String
)
