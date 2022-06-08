package com.bendingbytes.shoes.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ShoeCacheEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val price: String,
    val image: String,
    val description: String
)