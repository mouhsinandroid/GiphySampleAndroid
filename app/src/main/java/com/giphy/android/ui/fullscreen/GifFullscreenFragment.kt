package com.giphy.android.ui.fullscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.giphy.android.databinding.FragmentGifFullscreenBinding
import com.giphy.android.util.Const


class GifFullscreenFragment : Fragment() {

    private lateinit var gifUrl:String

    private val viewModel: FullScreenViewModel by lazy {
        ViewModelProviders.of(this).get(FullScreenViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentGifFullscreenBinding.inflate(inflater , container, false)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        val bundle = this.arguments
        if (bundle != null) {
            gifUrl = bundle.getString(Const.GIF_FULL_SCREEN_URL).toString()
            viewModel.setUrlGif(gifUrl)
        }

        return binding.root

    }


}