package com.example.kmpnewsdemo.di

import com.example.kmpnewsdemo.persentation.FavoritesViewModel
import com.example.kmpnewsdemo.persentation.NewsViewModel
import org.koin.dsl.module

val presentationModule = module {
    factory { NewsViewModel(get(), get(), get()) }
    factory { FavoritesViewModel(get(), get()) }
}
