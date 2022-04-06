package com.example.coffeeshops

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoffeeShop(
    val id: Int,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("updated_at")
    val updatedAt: String,
    val name: String,
    val x: String,
    val y: String
)

@Serializable
data class TokenHolder(
    val token: String
)