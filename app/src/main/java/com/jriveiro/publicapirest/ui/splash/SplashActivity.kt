package com.jriveiro.publicapirest.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jriveiro.publicapirest.R
import com.jriveiro.publicapirest.bd.ContributorsDB
import com.jriveiro.publicapirest.model.api.Contributors
import com.jriveiro.publicapirest.ui.listcontributors.ListContributorsActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    private lateinit var  viewModel: SplashViewModel
    private lateinit var database: ContributorsDB
    var listaContributors= emptyList<Contributors>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        database=ContributorsDB.getDatabase(this)
        viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)

        initUI()
    }

    private fun initUI(){

        viewModel.getContributorsList()

        viewModel.contributorsList.observe(this, Observer { list ->
            listaContributors = list
            startDB()
        })
    }

    private fun startDB(){
          CoroutineScope(Dispatchers.IO).launch {
              val listaDataContributors= database.contributorDao().getAllContributors()
              if (listaDataContributors != listaContributors){
                database.contributorDao().insert(listaContributors)
                startActivity(ListContributorsActivity::class.java)
              }else{
                  startActivity(ListContributorsActivity::class.java)
              }

          }
    }

    fun startActivity(activity: Class<*>) {
        val startActivity = Intent(this, activity)
        startActivity(startActivity)
        finish()
    }
}