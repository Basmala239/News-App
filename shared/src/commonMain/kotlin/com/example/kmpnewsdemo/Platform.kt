package com.example.kmpnewsdemo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform