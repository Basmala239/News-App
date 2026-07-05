package com.example.kmpnewsdemo.data.network

import com.example.kmpnewsdemo.data.network.model.ArticleResponse
import com.example.kmpnewsdemo.data.network.model.NetworkArticle
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ArticleService(private val client: HttpClient) {
    private val url = "https://newsapi.org/v2/top-headlines?"
    private val country = "us"
    private val category = "business"
    private val apiKey = "cdf39ac4d64c4df597615cd9838e7aa9"
    suspend fun fetchArticles(): List<NetworkArticle> {
        val result = client.get(urlString = url) {
            parameter("country", country)
            parameter("category", category)
            parameter("apiKey", apiKey) }
        when(result.status.value){
            in 200..299 -> {
                val response = result.body<ArticleResponse>()
                return response.articles
            }
            else -> return emptyList()
        }
    }
}