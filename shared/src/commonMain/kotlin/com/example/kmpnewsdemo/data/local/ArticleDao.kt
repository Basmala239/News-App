package com.example.kmpnewsdemo.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {
    @Query("SELECT * FROM articles")
    fun getFavoriteArticles(): Flow<List<LocalArticle>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticle(article: LocalArticle)
    @Query("DELETE FROM articles WHERE title = :title")
    suspend fun deleteArticleByTitle(title: String)
}