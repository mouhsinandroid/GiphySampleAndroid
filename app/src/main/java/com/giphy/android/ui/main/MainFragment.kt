package com.giphy.android.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView.OnEditorActionListener
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.giphy.android.util.Const.KEY_WORD
import com.giphy.android.R
import com.giphy.android.databinding.MainFragmentBinding
import com.giphy.android.ui.search.SearchGifsFragment
import com.giphy.android.util.Util.Companion.addFragment
import com.giphy.android.util.Util.Companion.clearEdtInput


class MainFragment : Fragment() {

    private val TAG  = MainFragment::class.java.simpleName


    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding = MainFragmentBinding.inflate(inflater , container, false)

        binding.lifecycleOwner = this

        binding.viewModelGif = viewModel

        searchGiftAction(binding)

        return binding.root
    }

    private fun searchGiftAction(binding: MainFragmentBinding) {
        binding.searchGifView.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                startSearchGifsFragment(viewModel.keyWord)
                val imm =
                    activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(binding.searchGifView.windowToken, 0)
                clearEdtInput(binding.searchGifView)
                return@OnEditorActionListener true
            }
            false
        })
    }

    private fun startSearchGifsFragment(keyword:String) {
        val fragment = SearchGifsFragment()
        val bundle = Bundle()
        bundle.putString(KEY_WORD,keyword)
        fragment.arguments = bundle
        addFragment(activity as AppCompatActivity, fragment, R.id.container_list, true)
    }



}
