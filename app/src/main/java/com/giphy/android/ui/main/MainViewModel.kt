package com.giphy.android.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.giphy.android.data.Gif
import com.giphy.android.util.Const.API_KEY
import com.giphy.android.util.GifCallApi.getGifApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel : ViewModel() {
    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )

    lateinit var keyWord:String

    private val _gif = MutableLiveData<Gif>()

    val urlGif: LiveData<Gif>
        get() = _gif

    init {
        getOneGifRandom()
    }

    private fun getOneGifRandom() {

        coroutineScope.launch {
            coroutineScope.launch {
                val getPropertiesDeferred = getGifApi().getOneGifRandomAsync(API_KEY)
                try {
                    val listResult = getPropertiesDeferred.await()
                    _gif.value = listResult.data
                    Timber.d("Success :: %s", _gif.toString())
                } catch (e: Exception) {
                    Timber.w("error :: %s", "Failure: ${e.message}")
                }
            }
        }
    }

    fun getKeySearch(s: CharSequence) {
        this.keyWord = s.toString()
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}
