package com.jriveiro.publicapirest.bd

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jriveiro.publicapirest.model.api.Contributors
import com.jriveiro.publicapirest.service.ContributorDao

/*@Database(
   // entities = [Contributors::class],
    version = 1,
    exportSchema = false
)*/
abstract class ContributorsDB : RoomDatabase() {
    //abstract fun contributorDao() : ContributorDao
}