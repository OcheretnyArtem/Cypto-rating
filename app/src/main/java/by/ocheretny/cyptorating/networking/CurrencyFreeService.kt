package by.ocheretny.cyptorating.networking

import by.ocheretny.cyptorating.networking.data.dto.currency.LatestDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyFreeService {

    @GET("/v1/cryptocurrency/quotes/latest?")
    suspend fun loadDataFromName(
        @Query("id")
        id: String = "1",
        @Query("convert")
        convert: String = "USD"
    ): Response<LatestDataResponse>

    @GET("/v1/cryptocurrency/quotes/latest?")
    suspend fun loadDataFromId(
        @Query("id")
        id: String = "1",
        @Query("convert")
        convertId: String = "2781"
    ): Response<LatestDataResponse>

    @GET("/v1/cryptocurrency/quotes/latest?")
    suspend fun loadSymbolDataByName(
        @Query("symbol")
        symbol: String = "BTC",
        @Query("convert")
        convert: String = "USD"
    ):Response<LatestDataResponse>

    @GET("/v1/cryptocurrency/quotes/latest?")
    suspend fun loadSymbolDataById(
        @Query("symbol")
        symbol: String = "BTC",
        @Query("convert_id")
        convert: String = "2781"
    ):Response<LatestDataResponse>



}