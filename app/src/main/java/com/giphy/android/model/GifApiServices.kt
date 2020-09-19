package com.giphy.android.model

import kotlinx.coroutines.Deferred

class GifApiServices {

    lateinit var api: GifApi

    fun getOneGifRandom(apiKey: String): Deferred<GifData> {
        return api.getOneGifRandomAsync(apiKey)
    }
}