package com.bendingbytes.shoes.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ShoeData(
    @PrimaryKey
    val id: Int,
    val name: String,
    val price: String,
    val image: String,
    val description: String
)