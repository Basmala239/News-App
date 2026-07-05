package com.example.kmpnewsdemo.di

import com.example.kmpnewsdemo.data.local.ArticlesDatabase
import com.example.kmpnewsdemo.data.local.getDatabaseBuilder
import com.example.kmpnewsdemo.data.network.ArticleService
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val dataModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    useAlternativeNames = false
                })
            }
        }
    }
    single { ArticleService(get()) }
    single { getDatabaseBuilder() }
    single { get<ArticlesDatabase>().getArticleDao() }
}