package com.giphy.android.model

import com.giphy.android.model.GifData
import com.giphy.android.model.ListGifs
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query


interface  GifApi {
    @GET("gifs/random")
    fun getOneGifRandomAsync(@Query("api_key") apiKey: String?): Deferred<GifData>

    @GET("gifs/search")
    fun searchGifsByKeyWordAsync(@Query("api_key") apiKey: String?, @Query("q") keyword: String?): Deferred<ListGifs>

}

