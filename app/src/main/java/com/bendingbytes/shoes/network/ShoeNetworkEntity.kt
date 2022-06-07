package com.bendingbytes.shoes.network

import androidx.room.Entity

@Entity
data class ShoeNetworkEntity(
    val id: Int,
    val name: String,
    val price: String,
    val image: String,
    val description: String
)
