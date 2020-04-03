package com.teddy.traffictrackerdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teddy.traffictrackerdemo.network.ApiClient
import kotlinx.coroutines.launch

class MockioViewModel : ViewModel() {
    private val _gettingValue = MutableLiveData<String>()
    val gettingValue: LiveData<String> = _gettingValue


    private val _progress = MutableLiveData<Boolean>()
    val progress: LiveData<Boolean> = _progress

    fun get() {
        viewModelScope.launch {
            _progress.postValue(true)
            _gettingValue.postValue(ApiClient.getInstance().mockyIOService.get())
            _progress.postValue(false)
        }
    }
}