package com.example.thecatapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private var apiService: ApiService? = null
    private const val BASE_URL = "https://api.thecatapi.com/v1/"

    fun getInstance(): ApiService =
        apiService ?: Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

}