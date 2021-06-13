package by.ocheretny.cyptorating.repository.currency

import by.ocheretny.cyptorating.networking.data.entities.currency.LatestData
import by.ocheretny.cyptorating.mappers.network.LatestDataMapper
import by.ocheretny.cyptorating.networking.currency.CurrencyFreeApi

class CurrencyFreeRepository {

    private val api = CurrencyFreeApi.provideRetrofit()
    private val mapper = LatestDataMapper()


    suspend fun loadDataFromName(id: String, convert: String): LatestData? {
        val response = api.loadDataFromName(id, convert)
        return if (response.isSuccessful) {
            response.body()?.let { mapper.map(it) }
        } else {
            throw Throwable(response.errorBody().toString())
        }
    }

    suspend fun loadDataFromId(id: String, convert: String): LatestData? {
        val response = api.loadDataFromId(id, convert)
        return if (response.isSuccessful) {
            response.body()?.let { mapper.map(it) }
        } else {
            throw Throwable(response.errorBody().toString())
        }
    }

    suspend fun loadSymbolDataByName(symbol: String, convert: String): LatestData? {
        val response = api.loadSymbolDataByName(symbol, convert)
        return if (response.isSuccessful) {
            response.body()?.let { mapper.map(it) }
        } else {
            throw Throwable(response.errorBody().toString())
        }
    }

    suspend fun loadSymbolDataById(symbol: String, convert: String): LatestData? {
        val response = api.loadSymbolDataById(symbol, convert)
        return if (response.isSuccessful) {
            response.body()?.let { mapper.map(it) }
        } else {
            throw Throwable(response.errorBody().toString())
        }
    }

}