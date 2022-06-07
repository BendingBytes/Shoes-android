package com.bendingbytes.shoes.network

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.bendingbytes.shoes.domain.Shoe
import retrofit2.http.Query


@Dao
interface ShoeDao {
    fun getAll(): List<Shoe>


    fun loadAllByIds(userIds: IntArray): List<Shoe>


    fun findByName(first: String, last: String): Shoe

    @Insert
    fun insertAll(vararg users: Shoe)

    @Delete
    fun delete(user: Shoe)
}