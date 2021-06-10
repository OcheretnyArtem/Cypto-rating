package com.uogames.longProject.HW8.networking.currency

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.uogames.longProject.HW8.networking.CurrencyService
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ApiKeyInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original: Request = chain.request()
        val request = original.newBuilder()
            .header("X-CMC_PRO_API_KEY", "3530d567-a94f-4878-8ed0-88154319d7b0")
            .build()
        return chain.proceed(request)
    }
}

object CurrencyApi {

    fun provideRetrofit(): CurrencyService {

        val interceptor = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(ApiKeyInterceptor())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://pro-api.coinmarketcap.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
            .client(client)
            .build()

        return retrofit.create()
    }
}
