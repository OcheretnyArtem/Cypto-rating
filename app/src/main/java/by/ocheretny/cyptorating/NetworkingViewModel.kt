package com.uogames.longProject.HW8

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uogames.longProject.HW8.data.entities.currency.ListingData
import com.uogames.longProject.HW8.repository.currency.CurrencyRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NetworkingViewModel : ViewModel() {

    private val repository = CurrencyRepository()
    private val scope = CoroutineScope(Dispatchers.IO)


    private val _listingData = MutableLiveData<ListingData>()
    val listingData: LiveData<ListingData> = _listingData

    private val _exceptionLoad = MutableLiveData<String>()
    val exceptionLoad: LiveData<String> = _exceptionLoad

    fun updateListingData() {
        scope.launch {
            try {
                _listingData.postValue(repository.loadCurrency())
            } catch (e: Exception) {
                _exceptionLoad.postValue(e.message)
            }
        }
    }


}