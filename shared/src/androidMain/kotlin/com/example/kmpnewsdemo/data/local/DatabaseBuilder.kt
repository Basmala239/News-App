package com.example.kmpnewsdemo.data.local

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

lateinit var appContext: Context

actual fun getDatabaseBuilder(): ArticlesDatabase {
    val dbFile = appContext.getDatabasePath("articles.db")

    return Room.databaseBuilder<ArticlesDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
        .setDriver(BundledSQLiteDriver())
        .build()
}