package com.giphy.android.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Gif (

    var type: String,
    var id: String,
    var url: String,
    var slug: String,
    var username: String,
    var source: String,
    var title: String,
    var rating: String,
    var images: Images,


    @SerializedName("is_sticker")
    @Expose
    var isSticker: String,

    @SerializedName("bitly_gif_url")
    @Expose
    var bitlyGifUrl: String,

    @SerializedName("bitly_url")
    @Expose
    var bitlyUrl: String,

    @SerializedName("embed_url")
    @Expose
    var embedUrl: String,

    @SerializedName("content_url")
    @Expose
    var contentUrl: String,

    @SerializedName("source_tld")
    @Expose
    var sourceTld: String,

    @SerializedName("source_post_url")
    @Expose
    var sourcePostUrl: String,

    @SerializedName("import_datetime")
    @Expose
    var importDatetime: String,

    @SerializedName("trending_datetime")
    @Expose
    var trendingDatetime: String,

    @SerializedName("image_url")
    @Expose
    var imageUrl: String




){

    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun bindGifItem(imgView: ImageView, gifUrl: String?) {
                gifUrl?.let {
                    Glide.with(imgView.context)
                        .asGif()
                        .load(gifUrl)
                        .into(imgView)
                }
    }

}
}

data class GifData (var data: Gif)
data class ListGifs (var data: List<Gif>)