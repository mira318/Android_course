package com.example.App.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.MyApp.network.MarsApi
import com.example.MyApp.network.MarsPhoto
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {

    private val _status = MutableLiveData<String>()
    private val _photos = MutableLiveData<MarsPhoto>()

    val status: LiveData<String> = _status
    val photos: LiveData<MarsPhoto> = _photos
    init {
        getMarsPhotos()
    }

    private fun getMarsPhotos() {
        viewModelScope.launch{
            try {
                _photos.value = MarsApi.retrofitService.getPhotos()[0]
                _status.value = "First url ${_photos.value!!.imgSrc} "
            } catch (e:Exception){
                _status.value = "Failure with internet connection: ${e.message}"
            }
        }
    }
}
