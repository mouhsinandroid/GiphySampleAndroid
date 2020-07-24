package com.giphy.android.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.giphy.android.data.Gif
import com.giphy.android.util.Const.API_KEY
import com.giphy.android.util.GifCallApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber

class SearchViewModel: ViewModel() {

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )

    private var keyWordGif  = MutableLiveData<String>()

    private val _listGifsByKeyWord = MutableLiveData<List<Gif>>()
    val listGifsByKeyWord: LiveData<List<Gif>>
        get() = _listGifsByKeyWord


    init {
        getGiftByKeyWord(setKeyWord(keyWordGif.value.toString()))
    }

    private fun getGiftByKeyWord(keyword: MutableLiveData<String>) {

        coroutineScope.launch {
            coroutineScope.launch {
                val getPropertiesDeferred = GifCallApi.getGifApi().searchGifsByKeyWordAsync(API_KEY,keyword.value.toString())
                try {
                    val listResult = getPropertiesDeferred.await()
                    _listGifsByKeyWord.value = listResult.data
                    Timber.d("Success :: %s",_listGifsByKeyWord.toString())

                } catch (e: Exception) {
                    Timber.w("error :: %s", "Failure: ${e.message}")
                }
            }
        }
    }

    fun setKeyWord(key:String): MutableLiveData<String> {
        keyWordGif.value= key
        return keyWordGif
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}