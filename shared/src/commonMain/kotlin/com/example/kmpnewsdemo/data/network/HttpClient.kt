package com.example.kmpnewsdemo.data.network

import androidx.room.util.performSuspending
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

val httpClient = HttpClient {

    //logging
    install(Logging){
        level = LogLevel.ALL
    }

    install(ContentNegotiation){
        json(
            json = Json{
                ignoreUnknownKeys = true
                prettyPrint = true
            }
        )
    }
}

/*suspend fun myFun(){
    httpClient.get(urlString = "https://newsapi.org/v2/top-headlines?"){
        parameter("country", "us")
    }

}*/



