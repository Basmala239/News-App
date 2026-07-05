package com.example.kmpnewsdemo.data.local

import androidx.room.Room
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSHomeDirectory

@OptIn(ExperimentalForeignApi::class)
actual fun getDatabaseBuilder(): ArticlesDatabase {

    val dbFile = NSHomeDirectory() + "/articles.db"

    return Room.databaseBuilder<ArticlesDatabase>(
        name = dbFile,
 //       factory = { ArticlesDatabase::class.instantiateImpl()}
    )
        .setDriver(androidx.sqlite.driver.bundled.BundledSQLiteDriver())
        .build()

}
