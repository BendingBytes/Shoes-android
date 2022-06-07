package com.bendingbytes.shoes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.bendingbytes.shoes.domain.Shoe
import retrofit2.http.Query


@Dao
interface ShoeDao {
    fun getAll(): List<Shoe>
    
    fun findById(id: Int): Shoe

    @Insert
    fun insert(vararg users: Shoe)

    @Delete
    fun delete(user: Shoe)
}