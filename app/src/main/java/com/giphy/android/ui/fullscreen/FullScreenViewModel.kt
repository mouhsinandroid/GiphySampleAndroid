package com.giphy.android.ui.fullscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FullScreenViewModel: ViewModel() {

    private val _urlGif  = MutableLiveData<String>()
    val urlGif  : LiveData<String>
                get() = _urlGif


    fun setUrlGif(key:String): MutableLiveData<String> {
        _urlGif.value= key
        return _urlGif
    }

}