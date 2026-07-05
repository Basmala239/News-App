package com.example.kmpnewsdemo

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import com.example.kmpnewsdemo.persentation.FavoritesViewModel
import com.example.kmpnewsdemo.persentation.NewsApp
import com.example.kmpnewsdemo.persentation.NewsViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun App() {
    MaterialTheme {
        val newsViewModel = koinViewModel<NewsViewModel>()
        val favoritesViewModel = koinViewModel<FavoritesViewModel>()

        NewsApp(newsViewModel, favoritesViewModel)
    }
}