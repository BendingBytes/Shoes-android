package com.bendingbytes.shoes.network

import retrofit2.http.GET

interface ShoeService {
    //interceptor koji prosledjujes klijentu, nova klasa

    @GET("shoes")
    suspend fun getShoes(): List<ShoeNetworkEntity>
}