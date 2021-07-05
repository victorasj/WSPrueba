package com.victorasj.wsprueba.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class MoviesDatabase : RoomDatabase() {

    companion object {
        fun build(context: Context) = Room.databaseBuilder(
            context,
            MoviesDatabase::class.java,
            "movies-db")
            .build()
    }


    abstract fun movieDao() : MovieDao

}