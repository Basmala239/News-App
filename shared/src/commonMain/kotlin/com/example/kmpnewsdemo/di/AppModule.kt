package com.example.kmpnewsdemo.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

val appModules = listOf(dataModule, domainModule, presentationModule)

fun initKoin(appDeclaration: KoinAppDeclaration? = null) = startKoin {
    appDeclaration?.invoke(this)
    modules(appModules)
}