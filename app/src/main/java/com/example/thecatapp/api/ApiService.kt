package com.example.thecatapp.api

import com.example.thecatapp.BuildConfig
import com.example.thecatapp.model.CatResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("images/search?api_key=${BuildConfig.API_KEY}")
    suspend fun getCatsImages(
        @Query("limit") limit: Int = 20
    ): List<CatResponse>

}
