package com.giphy.android.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

import com.giphy.android.databinding.SearchGifsFragmentBinding
import com.giphy.android.util.Const.KEY_WORD


class SearchGifsFragment : Fragment() {

    private val viewModel: SearchViewModel by lazy {
        ViewModelProviders.of(this).get(SearchViewModel::class.java)
    }


    private lateinit var  binding: SearchGifsFragmentBinding
    private lateinit var keywordSearch:String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SearchGifsFragmentBinding.inflate(inflater , container, false)
        binding.lifecycleOwner = this

        binding.searchViewModel = viewModel

        val bundle = this.arguments
        if (bundle != null) {
            keywordSearch = bundle.getString(KEY_WORD).toString()
            viewModel.setKeyWord(keywordSearch)


        }


        return binding.root
    }



}