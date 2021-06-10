package com.uogames.longProject.HW8.repository.currency

import com.uogames.longProject.HW8.data.entities.currency.ListingData
import com.uogames.longProject.HW8.mappers.currency.ListingDataMapper
import com.uogames.longProject.HW8.networking.currency.CurrencyApi


class CurrencyRepository {

    private val api = CurrencyApi.provideRetrofit()
    private val rateResponseMapper = ListingDataMapper()

    suspend fun  loadCurrency(): ListingData? {
        val response = api.loadListingData()
        return if(response.isSuccessful){
            response.body()?.let { rateResponseMapper.map(it) }
        } else {
            throw Throwable(response.errorBody().toString())
        }
    }

}
