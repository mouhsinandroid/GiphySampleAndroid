package com.giphy.android.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Images (@SerializedName("downsized") var imageData: Image)
data class Image (
    var  height: String,
    var width: String,
    var size: String,
    var url: String,
    var mp4: String,
    var webp: String,
    var frames: String,

    @SerializedName("mp4_size")
    @Expose
    var mp4Size: String,

    @SerializedName("webp_size")
    @Expose
    var webpSize: String
)