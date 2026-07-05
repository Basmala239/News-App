package com.example.kmpnewsdemo.persentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmpnewsdemo.domain.Article
import com.example.kmpnewsdemo.domain.GetFavoritesUseCase
import com.example.kmpnewsdemo.domain.RemoveFromFavoritesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class FavoritesState(
    val isLoading: Boolean = false,
    val favorites: List<Article> = emptyList(),
    val errorMessage: String? = null
)

class FavoritesViewModel(
    private val getFavoritesUseCase: GetFavoritesUseCase,
    private val removeFromFavoritesUseCase: RemoveFromFavoritesUseCase
): ViewModel() {

    private val _state: MutableStateFlow<FavoritesState> = MutableStateFlow(FavoritesState())
    val state: StateFlow<FavoritesState> = _state.asStateFlow()

    init {
        loadFavorites()
    }

    private fun loadFavorites() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            try {
                getFavoritesUseCase().catch { e ->
                    _state.update { it.copy(isLoading = false, errorMessage = e.message) }
                }.collect { list ->
                    _state.update { it.copy(isLoading = false, favorites = list) }
                }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, errorMessage = e.message) }
            }
        }
    }

    fun removeFavorite(article: Article) {
        viewModelScope.launch {
            removeFromFavoritesUseCase(article)
            _state.update { current ->
                current.copy(favorites = current.favorites.filterNot { it.title == article.title })
            }
        }
    }
}


