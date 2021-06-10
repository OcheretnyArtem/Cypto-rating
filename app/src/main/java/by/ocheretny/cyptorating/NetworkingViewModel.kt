package com.uogames.longProject.HW8

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.ocheretny.cyptorating.data.entities.currency.LatestData
import by.ocheretny.cyptorating.repository.currency.CurrencyFreeRepository
import com.uogames.longProject.HW8.data.entities.currency.ListingData
import com.uogames.longProject.HW8.repository.currency.CurrencyRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NetworkingViewModel : ViewModel() {

    private val repository = CurrencyRepository()
    private val freeRepository = CurrencyFreeRepository()
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

    fun loadLatestFromName(id: String, convertName: String, block: (LatestData?) -> Unit) {
        scope.launch {
            val result = freeRepository.loadDataFromName(id, convertName)
            launch(Dispatchers.Main) { block(result) }
        }
    }

    fun loadLatestFromId(id: String, convertId: String, block: (LatestData?) -> Unit) {
        scope.launch {
            val result = freeRepository.loadDataFromId(id, convertId)
            launch(Dispatchers.Main) { block(result) }
        }
    }


}