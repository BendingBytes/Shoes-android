package com.bendingbytes.shoes.room

import androidx.room.*

@Dao
interface ShoeDao {
    fun getAll(): List<ShoeCacheEntity>
    
    fun findById(id: Int): ShoeCacheEntity

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg user: ShoeCacheEntity)

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg shoes: List<ShoeCacheEntity>)

    @Delete
    fun delete(shoe: ShoeCacheEntity)

    @Query("DELETE FROM  ShoeCacheEntity")
    fun deleteAll() : List<ShoeCacheEntity>
}