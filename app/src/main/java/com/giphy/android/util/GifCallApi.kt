package com.giphy.android.util

import com.giphy.android.api.GifApi
import com.giphy.android.api.GifClient
object GifCallApi {
    fun getGifApi(): GifApi {
        return  GifClient.getGif()!!.create(GifApi::class.java)
    }
}

