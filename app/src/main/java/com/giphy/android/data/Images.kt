package com.giphy.android.data

import com.google.gson.annotations.SerializedName

data class Images (@SerializedName("downsized") var imageData: Image)