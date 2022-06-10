package com.bendingbytes.shoes.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  ShoeClient {
    private var instance: ShoeClient? = null

    private var retrofit = Retrofit.Builder()
        .baseUrl("https://shoes-collections.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service: ShoeService = retrofit.create(ShoeService::class.java)

    @Synchronized
    fun getInstance(): ShoeClient? {
        if (instance == null) {
            instance = ShoeClient
        }
        return instance
    }
}