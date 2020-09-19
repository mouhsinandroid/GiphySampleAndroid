package com.giphy.android.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.giphy.android.model.Gif
import com.giphy.android.ui.search.GifAdapter


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

@BindingAdapter("listData")
fun  bindRecyclerView(recyclerView: RecyclerView, data: List<Gif>?) {
    val spanCount = 2
    var adapter = recyclerView.adapter

    val layoutManager = recyclerView.layoutManager

    val linearLayoutManager = LinearLayoutManager(recyclerView.context, LinearLayoutManager.VERTICAL, false)
    recyclerView.layoutManager = linearLayoutManager
    recyclerView.layoutManager = GridLayoutManager(recyclerView.context, spanCount)
    recyclerView.setHasFixedSize(true)

    if (layoutManager == null) {
        recyclerView.layoutManager = GridLayoutManager(recyclerView.context, spanCount)
        recyclerView.setHasFixedSize(true)
    }

    if (adapter == null) {
        adapter = data?.let { GifAdapter(it) }

        recyclerView.adapter = adapter
    }
    else{
        adapter.notifyDataSetChanged()
    }
}

