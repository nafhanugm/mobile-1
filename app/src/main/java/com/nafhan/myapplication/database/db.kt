package com.nafhan.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nafhan.myapplication.dao.VoterDao
import com.nafhan.myapplication.entity.Voter


@Database(entities = [Voter::class], version = 1)
abstract class VoterDatabase : RoomDatabase() {
    abstract fun voterDao(): VoterDao

    companion object {
        @Volatile
        private var INSTANCE: VoterDatabase? = null

        fun getDatabase(context: Context): VoterDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VoterDatabase::class.java,
                    "voter_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}