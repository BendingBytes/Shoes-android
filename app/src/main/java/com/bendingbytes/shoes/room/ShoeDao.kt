package com.bendingbytes.shoes.room

import androidx.room.*

@Dao
interface ShoeDao {
    @Query("SELECT * FROM shoes_entity")
    fun getAll(): List<ShoeCacheEntity>

    @Query("SELECT * FROM shoes_entity WHERE id IN (:shoeId)")
    fun findById(shoeId: Int): ShoeCacheEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg user: ShoeCacheEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg shoes: List<ShoeCacheEntity>)

    @Delete
    fun delete(shoe: ShoeCacheEntity)

    @Query("DELETE FROM shoes_entity")
    fun deleteAll(): List<ShoeCacheEntity>
}