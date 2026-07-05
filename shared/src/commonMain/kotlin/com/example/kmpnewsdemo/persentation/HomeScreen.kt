package com.example.kmpnewsdemo.persentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun HomeScreen(viewModel: NewsViewModel) {
    LaunchedEffect(Unit) {
        viewModel.handleIntent(NewsIntent.LoadNews)
    }
    val state by viewModel.state.collectAsStateWithLifecycle()
    if (state.isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else if (state.articles.isEmpty()) {
        Text("No articles available", modifier = Modifier.padding(16.dp))
    } else {
        LazyColumn {
            items(state.articles) { article ->
                NewsCard(article) {
                    val intent = if (article.isFavorite) NewsIntent.RemoveFromFavorites(article)
                    else NewsIntent.AddToFavorites(article)
                    viewModel.handleIntent(intent)
                }
            }
        }
    }
}