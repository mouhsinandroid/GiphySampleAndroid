package com.giphy.android.data

import com.google.gson.annotations.SerializedName

data class ListGifs (@SerializedName("data") var data: List<Gif>)