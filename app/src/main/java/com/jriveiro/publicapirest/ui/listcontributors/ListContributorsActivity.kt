package com.jriveiro.publicapirest.ui.listcontributors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jriveiro.publicapirest.R
import com.jriveiro.publicapirest.bd.ContributorApp

class ListContributorsActivity : AppCompatActivity() {
   // val  app = applicationContext as ContributorApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_contributors)

    }
}