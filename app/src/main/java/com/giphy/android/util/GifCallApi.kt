package com.giphy.android.util

import com.giphy.android.model.GifApi
import com.giphy.android.model.GifClient
object GifCallApi {
    fun getGifApi(): GifApi {
        return  GifClient.getGif()!!.create(GifApi::class.java)
    }
}

