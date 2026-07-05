package com.example.kmpnewsdemo.domain

import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(): Flow<List<Article>>

    suspend fun addToFavorites(article: Article)

    suspend fun removeFromFavorites(article: Article)

    fun getFavorites(): Flow<List<Article>>

}