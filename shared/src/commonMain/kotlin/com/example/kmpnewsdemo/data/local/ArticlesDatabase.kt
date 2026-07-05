package com.example.kmpnewsdemo.data.local

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor

@Database(entities = [LocalArticle::class], version = 1)
abstract class ArticlesDatabase : RoomDatabase() {
    abstract fun getArticleDao(): ArticleDao
}

expect fun getDatabaseBuilder(): ArticlesDatabase
