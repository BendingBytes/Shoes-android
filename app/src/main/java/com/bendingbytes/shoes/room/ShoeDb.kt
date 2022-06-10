package com.bendingbytes.shoes.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

@Database(entities = [ShoeCacheEntity::class], version = 1)
abstract class ShoeDb : RoomDatabase() {
    abstract fun shoeDao(): ShoeDao

    abstract val applicationContext: Context
    private val db = databaseBuilder(
        applicationContext,
        ShoeDb::class.java, "Shoe_data"
    ).build()

    private val shoeDao = db.shoeDao()
    val shoes: List<ShoeCacheEntity> = shoeDao.getAll()
}