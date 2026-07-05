package com.example.kmpnewsdemo.data.repository

import com.example.kmpnewsdemo.data.local.ArticleDao
import com.example.kmpnewsdemo.data.local.LocalArticle
import com.example.kmpnewsdemo.data.mappers.toDomain
import com.example.kmpnewsdemo.data.mappers.toEntity
import com.example.kmpnewsdemo.data.mappers.toUIArticle
import com.example.kmpnewsdemo.data.network.ArticleService
import com.example.kmpnewsdemo.domain.Article
import com.example.kmpnewsdemo.domain.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class Repository(
    private val articleService: ArticleService,
    private val articleDao: ArticleDao
): NewsRepository {

    override fun getNews(): Flow<List<Article>> {
       return flow {
           val networkArticles = articleService.fetchArticles()

           val favoriteLocal = articleDao.getFavoriteArticles().first()
           val favoriteTitles = favoriteLocal.map { it.title }.toSet()

           val mappedArticles = networkArticles.map { it.toUIArticle().copy(
               isFavorite = favoriteTitles.contains(it.title)
           ) }

           emit(mappedArticles)
       }
    }

    override suspend fun addToFavorites(article: Article) {
        val localArticle = article.toEntity()
        articleDao.insertArticle(localArticle)
    }

    override suspend fun removeFromFavorites(article: Article) {
        articleDao.deleteArticleByTitle(article.title)
    }

    override fun getFavorites(): Flow<List<Article>> {
        return articleDao.getFavoriteArticles().map { list ->
            list.map { local ->
                local.toDomain()
            }
        }
    }
}