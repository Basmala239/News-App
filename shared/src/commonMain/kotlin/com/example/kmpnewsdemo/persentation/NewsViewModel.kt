package com.example.kmpnewsdemo.persentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmpnewsdemo.domain.AddToFavoritesUseCase
import com.example.kmpnewsdemo.domain.RemoveFromFavoritesUseCase
import com.example.kmpnewsdemo.domain.Article
import com.example.kmpnewsdemo.domain.GetNewsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NewsViewModel(
    private val getNewsUseCase: GetNewsUseCase,
    private val addToFavoritesUseCase: AddToFavoritesUseCase,
    private val removeFromFavoritesUseCase: RemoveFromFavoritesUseCase
): ViewModel() {
    private val _state: MutableStateFlow<NewsState> = MutableStateFlow(NewsState())
    val state: StateFlow<NewsState> = _state.asStateFlow()
    fun handleIntent(intent: NewsIntent){
        when(intent){
            is NewsIntent.LoadNews -> loadNews()
            is NewsIntent.AddToFavorites -> addToFavorites(intent.article)
            is NewsIntent.RemoveFromFavorites -> removeFromFavorites(intent.article)
            else -> {}
    }
}

    private fun loadNews() {
        println("DEBUG: LoadNews called") // Check your Logcat
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            getNewsUseCase()
                .catch { error ->
                    println("DEBUG: Error: ${error.message}") // Check if network call fails
                    _state.update { it.copy(isLoading = false, errorMessage = error.message) }
                }
                .collect { articles ->
                    println("DEBUG: Received ${articles.size} articles") // Check if data arrives
                    _state.update { it.copy(isLoading = false, articles = articles) }
                }
        }
    }

    private fun addToFavorites(article: Article) {
        viewModelScope.launch {
            addToFavoritesUseCase(article)
            _state.update { current ->
                current.copy(articles = current.articles.map { if (it.title == article.title) it.copy(isFavorite = true) else it })
            }
        }
    }

    private fun removeFromFavorites(article: Article) {
        viewModelScope.launch {
            removeFromFavoritesUseCase(article)
            _state.update { current ->
                current.copy(articles = current.articles.map { if (it.title == article.title) it.copy(isFavorite = false) else it })
            }
        }
    }
}