package com.example.kmpnewsdemo.persentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun FavoritesScreen(viewModel: FavoritesViewModel) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    if (state.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else if (state.favorites.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("No favorites yet. \nStart saving your favorite news!", textAlign = TextAlign.Center)
        }
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.favorites, key = { it.title }) { article ->
                NewsCard(article) { viewModel.removeFavorite(article) }
            }
        }
    }
}