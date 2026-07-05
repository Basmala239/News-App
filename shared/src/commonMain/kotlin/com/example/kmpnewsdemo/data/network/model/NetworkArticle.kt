package com.example.kmpnewsdemo.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkArticle(
    val title: String,
    val description: String?,
    @SerialName(value = "publishedAt")
    val date: String,
    @SerialName(value = "urlToImage")
    val imageURL: String?
)