package com.jriveiro.publicapirest.bd

import android.app.Application
import androidx.room.Room

class ContributorApp : Application() {

    val room = Room
        .databaseBuilder(this, ContributorsDB::class.java, "contributor")
        .build()
}