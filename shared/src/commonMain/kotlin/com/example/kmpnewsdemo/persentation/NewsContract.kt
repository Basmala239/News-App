package com.example.kmpnewsdemo.persentation

import com.example.kmpnewsdemo.domain.Article

data class NewsState(
    val isLoading: Boolean = false,
    val articles: List<Article> = emptyList(),
    val errorMessage: String? = null
)

sealed interface NewsIntent{
    object LoadNews: NewsIntent
    data class AddToFavorites(val article: Article): NewsIntent
    data class RemoveFromFavorites(val article: Article): NewsIntent
    object LoadFavorites: NewsIntent
}