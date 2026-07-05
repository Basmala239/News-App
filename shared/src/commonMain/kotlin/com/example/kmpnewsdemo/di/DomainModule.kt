package com.example.kmpnewsdemo.di

import com.example.kmpnewsdemo.data.repository.Repository
import com.example.kmpnewsdemo.domain.AddToFavoritesUseCase
import com.example.kmpnewsdemo.domain.GetFavoritesUseCase
import com.example.kmpnewsdemo.domain.RemoveFromFavoritesUseCase
import com.example.kmpnewsdemo.domain.GetNewsUseCase
import com.example.kmpnewsdemo.domain.NewsRepository
import org.koin.dsl.module

val domainModule = module {

    single<NewsRepository> { Repository(get(), get())}

    factory { GetNewsUseCase(get()) }
    factory { AddToFavoritesUseCase(get()) }
    factory { RemoveFromFavoritesUseCase(get()) }
    factory { GetFavoritesUseCase(get()) }
}