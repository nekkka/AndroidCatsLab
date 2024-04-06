package com.example.kotiki.model.network

import com.example.kotiki.model.entity.Kotik
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface KotikService {
    @GET("cats?x-api-key=IQhgB1xircwnSIg6p2lVKQ==k3DIFrjL15mkXojU")
    fun fetchKotikList(@Query("name")name: String): Call<List<Kotik>>
}