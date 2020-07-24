package com.giphy.android.databinding


import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("goneIfNotNull")
fun goneIfNotNull(view: View, it: Any?) {
    view.visibility = if (it != null) View.GONE else View.VISIBLE
}

@BindingAdapter("gifUrl")
fun bindGif(imgView: ImageView, gifUrl: String?) {
    gifUrl?.let {
        Glide.with(imgView.context)
            .asGif()
            .load(gifUrl)
            .into(imgView)
    }

}