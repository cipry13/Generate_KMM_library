package com.example.coffeeshops

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.serialization.ExperimentalSerializationApi

@ExperimentalSerializationApi
class ApiClass {
    private val httpClient = HttpClient {
        install(JsonFeature) {
            val json = kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
                useAlternativeNames = false
            }
            serializer = KotlinxSerializer(json)
        }
    }

    suspend fun getData(): List<CoffeeShop> {
        val token = postToken().token

        val requestResult: List<CoffeeShop> = httpClient.get(apiUrl + getPath) {
            parameter("token", token)
        }
        return requestResult
    }

    private suspend fun postToken(): TokenHolder = httpClient.post(apiUrl + postPath)

    companion object {
        private const val apiUrl = "https://blue-bottle-api-test.herokuapp.com/"
        private const val getPath = "v1/coffee_shops"
        private const val postPath = "v1/tokens"
    }
}