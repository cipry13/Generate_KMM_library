package org.jetbrains.base64

import com.example.coffeeshops.ApiClass
import com.example.coffeeshops.CoffeeShop
import kotlinx.browser.window

actual object Base64Factory {
    actual fun createEncoder(): Base64Encoder = JsBase64Encoder
}

object JsBase64Encoder : Base64Encoder {
    override fun encode(src: ByteArray): ByteArray {
        val string = src.decodeToString()
        val encodedString = window.btoa(string)
        return encodedString.encodeToByteArray()
    }

    suspend fun getApiData(): List<CoffeeShop> = ApiClass().getData()
}

