package com.example.kmpnewsdemo.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class ArticleResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<NetworkArticle>
)