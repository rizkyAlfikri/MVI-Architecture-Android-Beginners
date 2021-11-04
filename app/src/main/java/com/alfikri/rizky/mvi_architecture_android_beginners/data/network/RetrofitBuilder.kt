package com.alfikri.rizky.mvi_architecture_android_beginners.data.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * @author Rizky Alfikri Rachmat (rizkyalfikri@gmail.com)
 * @version RetrofitBuilder, v 0.1 11/3/2021 10:37 PM by Rizky Alfikri Rachmat
 */
object RetrofitBuilder {

    private const val BASE_URL = "https://test.mockapi.io/"
    private fun getRetrofit() =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)
}