package com.giphy.android.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.giphy.android.R
import com.giphy.android.databinding.ItemGridGifBinding
import com.giphy.android.model.Gif
import com.giphy.android.ui.fullscreen.GifFullscreenFragment
import com.giphy.android.util.Const
import com.giphy.android.util.Util


class GifAdapter(private val items: List<Gif>) : RecyclerView.Adapter<GifAdapter.ViewHolder>() {
     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = ItemGridGifBinding.inflate(inflater)
            return ViewHolder(binding).listen { pos, type ->
                val item = items[pos]
                goToFullScreen(item, parent)

            }
        }

    private fun goToFullScreen(item: Gif, parent: ViewGroup) {
        val fragment = GifFullscreenFragment()
        val bundle = Bundle()
        bundle.putString(Const.GIF_FULL_SCREEN_URL, item.images.imageData.url)
        fragment.arguments = bundle
        Util.addFragment(
            parent.context as AppCompatActivity,
            fragment,
            R.id.container_full_screen,
            true
        )
    }

    override fun getItemCount(): Int = items.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

        inner class ViewHolder(private val binding: ItemGridGifBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(item: Gif) {
                binding.gif = item
                binding.executePendingBindings()
            }
        }

    private fun <T : RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
        itemView.setOnClickListener {
            event.invoke(adapterPosition, itemViewType)
        }
        return this
    }


    }


