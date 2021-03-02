package com.jriveiro.publicapirest.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jriveiro.publicapirest.R
import com.jriveiro.publicapirest.bd.ContributorApp
import com.jriveiro.publicapirest.ui.listcontributors.ListContributorsActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var  viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)

        initUI()
    }

    private fun initUI(){

        viewModel.getContributorsList()

        viewModel.contributorsList.observe(this, Observer { list ->
            startActivity(ListContributorsActivity::class.java)
        })
    }

    fun startActivity(activity: Class<*>) {
        val startActivity = Intent(this, activity)
        startActivity(startActivity)
        finish()
    }
}