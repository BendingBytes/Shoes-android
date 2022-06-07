package com.bendingbytes.shoes.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Shoe(
    @PrimaryKey
    val id: Int,
    val name: String,
    val price: String,
    val image: String,
    val description: String
)
