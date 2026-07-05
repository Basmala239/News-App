package com.example.kmpnewsdemo.domain

class GetNewsUseCase(private val newsRepository: NewsRepository)  {

    operator fun invoke() = newsRepository.getNews()

}

class AddToFavoritesUseCase(private val newsRepository: NewsRepository) {

    suspend operator fun invoke(article: Article) = newsRepository.addToFavorites(article)

}

class RemoveFromFavoritesUseCase(private val newsRepository: NewsRepository) {

    suspend operator fun invoke(article: Article) = newsRepository.removeFromFavorites(article)

}

class GetFavoritesUseCase(private val newsRepository: NewsRepository) {

    operator fun invoke() = newsRepository.getFavorites()

}