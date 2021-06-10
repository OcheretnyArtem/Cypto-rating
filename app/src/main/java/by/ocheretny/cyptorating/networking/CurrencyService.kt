package com.uogames.longProject.HW8.networking

import com.uogames.longProject.HW8.data.dto.currency.ListingDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyService {

    @GET("/v1/cryptocurrency/listings/latest")
    suspend fun loadListingData(
        @Query("limit")
        limit: String = "100",
    ): Response<ListingDataResponse>

}