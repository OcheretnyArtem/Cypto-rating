package by.ocheretny.cyptorating.networking.currency

import by.ocheretny.cyptorating.networking.CurrencyFreeService
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.uogames.longProject.HW8.networking.CurrencyService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object CurrencyFreeApi {

    fun provideRetrofit(): CurrencyFreeService {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://web-api.coinmarketcap.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
            .build()

        return retrofit.create()
    }

}