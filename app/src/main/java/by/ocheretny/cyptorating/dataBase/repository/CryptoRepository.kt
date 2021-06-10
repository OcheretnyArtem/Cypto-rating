package by.ocheretny.cyptorating.dataBase.repository

import by.ocheretny.cyptorating.dataBase.CryptoDataBase
import by.ocheretny.cyptorating.dataBase.entity.currency.Data
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CryptoRepository(
    private val database: CryptoDataBase
) {
    private val daoData = database.DataDao()
    private val daoQuote = database.QuoteDao()
    private val ioScope = CoroutineScope(Dispatchers.IO)


    fun insertData(data: Data){
        ioScope.launch {
            daoData.insertData(data)
        }

    }

    fun updateData(data: Data){
        ioScope.launch {
            daoData.updateData(data)
        }

    }
}