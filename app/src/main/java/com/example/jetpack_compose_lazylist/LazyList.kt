package com.example.jetpack_compose_lazylist

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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

@Composable
fun ProfileUI(item: Profile) {
    Column(modifier = Modifier.fillMaxWidth().border(2.dp, Color.Black).padding(16.dp)) {
        Text(text = "First name : ${item.firstName}" )
        Text(text = "Second name : ${item.lastName}")
    }
}

data class Profile(
    val firstName: String,
    val lastName: String
)
