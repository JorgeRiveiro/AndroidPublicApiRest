package com.jriveiro.publicapirest.ui.splash;

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jriveiro.publicapirest.bd.ContributorsDB
import com.jriveiro.publicapirest.model.api.Contributors
import com.jriveiro.publicapirest.service.ContributorApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SplashViewModel : ViewModel() {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/repos/emberjs/ember.js/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: ContributorApiService = retrofit.create(ContributorApiService::class.java)

    val contributorsList = MutableLiveData<List<Contributors>>()

    fun getContributorsList() {
        val call = service.getContributorsList()

        call.enqueue(object : Callback<List<Contributors>> {
            override fun onFailure(call: Call<List<Contributors>>, t: Throwable) {
                call.cancel()
            }

            override fun onResponse(
                call: Call<List<Contributors>>,
                response: Response<List<Contributors>>
            ) {
                val res = response.body()

                contributorsList.postValue(res)
            }
        })
    }
}
