package com.example.kmpnewsdemo.data.mappers

import com.example.kmpnewsdemo.data.local.ArticlesDatabase
import com.example.kmpnewsdemo.data.local.LocalArticle
import com.example.kmpnewsdemo.data.network.model.NetworkArticle
import com.example.kmpnewsdemo.domain.Article

fun NetworkArticle.toUIArticle(): Article {

    return Article(
        title = this.title,
        description = this.description ?: "",
        imageURL = this.imageURL ?: "",
        publishDate = this.date,
        isFavorite = false
    )

}
fun LocalArticle.toDomain() = Article(
    title = title,
    description = description,
    imageURL = imageURL,
    publishDate = date,
    isFavorite = true
)

fun Article.toEntity() = LocalArticle(
    id = 0,
    title = title,
    description = description,
    date = publishDate,
    imageURL = imageURL
)
