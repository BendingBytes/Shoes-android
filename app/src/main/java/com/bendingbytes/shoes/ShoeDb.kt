package com.bendingbytes.shoes

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.bendingbytes.shoes.domain.Shoe
import com.bendingbytes.shoes.network.ShoeClient
import com.bendingbytes.shoes.network.ShoeDao

@Database(entities = [Shoe::class], version = 1)
abstract class ShoeDb : RoomDatabase() {
    abstract fun userDao(): ShoeDao

    abstract val applicationContext: Context
    val db = databaseBuilder(
        applicationContext,
        ShoeDb::class.java, "database-name"
    ).build()

    val userDao = db.userDao()
    val users: List<Shoe> = userDao.getAll()
}