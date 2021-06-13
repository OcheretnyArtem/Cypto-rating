package by.ocheretny.cyptorating.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import by.ocheretny.cyptorating.dataBase.CryptoDataBase
import by.ocheretny.cyptorating.dataBase.entity.currency.Data
import by.ocheretny.cyptorating.networking.data.entities.currency.LatestData
import by.ocheretny.cyptorating.dataBase.entity.currency.Quote
import by.ocheretny.cyptorating.dataBase.repository.CryptoRepository
import by.ocheretny.cyptorating.mappers.database.LatestDataMapper
import by.ocheretny.cyptorating.mappers.database.LatestQuoteMapper
import by.ocheretny.cyptorating.mappers.database.ListingDataMapper
import by.ocheretny.cyptorating.repository.currency.CurrencyFreeRepository
import com.uogames.longProject.HW8.data.entities.currency.ListingData
import com.uogames.longProject.HW8.repository.currency.CurrencyRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NetworkingViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CurrencyRepository()
    private val freeRepository = CurrencyFreeRepository()
    private val databaseRepository = CryptoRepository(CryptoDataBase.getINSTANCE(application));
    private val scope = CoroutineScope(Dispatchers.IO)

    fun updateQuote(nameData: String, convert: String, block: (Quote) -> Unit) {
        scope.launch {
            val quote = databaseRepository.getQuote(nameData, convert)
            launch(Dispatchers.Main) {
                if (quote.isNotEmpty())
                    block(quote[0])
            }
            val latestData = freeRepository.loadSymbolDataByName(nameData, convert)
            latestData?.data?.forEach {
                val data = databaseRepository.getDataBySymbol(it.key)
                val tData = LatestDataMapper().map(it.value)
                if (data.isNotEmpty()) {
                    databaseRepository.updateData(tData)
                } else {
                    databaseRepository.insertData(tData)
                }
                it.value.quote?.forEach { v ->
                    val dQuote = databaseRepository.getQuote(it.key, v.key)
                    val tQuote = LatestQuoteMapper().map(v.value, it.key, v.key)
                    if (dQuote.isNotEmpty()) {
                        tQuote.id = dQuote[0].id
                        databaseRepository.updateQuote(tQuote)
                    } else {
                        databaseRepository.insertQuote(tQuote)
                    }
                    launch(Dispatchers.Main) { block(tQuote) }
                }
            }
        }
    }

    fun updateTopCrypto(block: (List<Data>) -> Unit) {
        scope.launch {
            var listData = databaseRepository.getAllData()
            launch(Dispatchers.Main) { block(listData) }
            val data = repository.loadCurrency()
            data?.data?.forEach {
                val d = ListingDataMapper().map(it)
                val dat = it.symbol?.let { it1 -> databaseRepository.getDataBySymbol(it1) }
                if (dat?.size != 0) {
                    databaseRepository.updateData(d)
                } else {
                    databaseRepository.insertData(d)
                }
            }
            listData = databaseRepository.getAllData()

            launch(Dispatchers.Main) {
                block(listData)
            }
        }
    }

    fun loadSelectedCrypto(block: (List<Data>) -> Unit){
        scope.launch {
            val data = databaseRepository.getDataByCategory(1)
            launch(Dispatchers.Main) { block(data) }
        }
    }

    fun setDateCategory(data: Data){
        scope.launch {
            databaseRepository.updateData(data)
        }
    }

}