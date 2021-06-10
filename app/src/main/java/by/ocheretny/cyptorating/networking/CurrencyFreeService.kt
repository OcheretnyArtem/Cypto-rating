package by.ocheretny.cyptorating.networking

import by.ocheretny.cyptorating.data.dto.currency.LatestDataResponse
import com.uogames.longProject.HW8.data.dto.currency.ListingDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyFreeService {

    @GET("/v1/cryptocurrency/quotes/latest?id={id}&convert={convert}")
    suspend fun loadDataFromName(
        @Query("id")
        limit: String = "1",
        @Query("convert")
        convert: String = "USD"
    ): Response<LatestDataResponse>

    @GET("/v1/cryptocurrency/quotes/latest?id={id}&convert_id={convertId}")
    suspend fun loadDataFromId(
        @Query("id")
        limit: String = "1",
        @Query("convert")
        convertId: String = "2781"
    ): Response<LatestDataResponse>



}