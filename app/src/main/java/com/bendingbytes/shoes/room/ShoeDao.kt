package com.bendingbytes.shoes.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert

@Dao
interface ShoeDao {
    fun getAll(): List<ShoeCacheEntity>
    
    fun findById(id: Int): ShoeCacheEntity

    @Insert
    fun insert(vararg user: ShoeCacheEntity)

    @Insert
    fun insertAll(vararg users: List<ShoeCacheEntity>)

    @Delete
    fun delete(user: ShoeCacheEntity)
}