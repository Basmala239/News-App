package com.example.kmpnewsdemo.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles", )
data class LocalArticle(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val date: String,
    val imageURL: String
)
