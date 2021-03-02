package com.jriveiro.publicapirest.bd

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jriveiro.publicapirest.model.api.Contributors
import com.jriveiro.publicapirest.service.ContributorDao

@Database(
    entities = [Contributors::class],
    version = 1,
    exportSchema = false
)
abstract class ContributorsDB : RoomDatabase() {
    abstract fun contributorDao() : ContributorDao

    companion object{
        @Volatile
        private var INSTANCE : ContributorsDB? = null

        fun getDatabase(context:Context): ContributorsDB{
            val tempInstance = INSTANCE

            if (tempInstance!= null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContributorsDB::class.java,
                    "contributors_db"
                ).build()

                INSTANCE = instance

                return instance
            }
        }

    }
}