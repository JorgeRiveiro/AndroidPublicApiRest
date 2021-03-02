package com.jriveiro.publicapirest.ui.contributorinfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jriveiro.publicapirest.model.api.ContributorInfo
import com.jriveiro.publicapirest.service.ContributorApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ContributorInfoViewModel : ViewModel() {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: ContributorApiService = retrofit.create(ContributorApiService::class.java)

    val contInfo = MutableLiveData<ContributorInfo>()

    fun getContributorInfo(login: String){

        val call = service.getContributorInfo(login)

        call.enqueue(object : Callback<ContributorInfo>{
            override fun onFailure(call: Call<ContributorInfo>, t: Throwable) {
                call.cancel()
            }

            override fun onResponse(call: Call<ContributorInfo>, response: Response<ContributorInfo>) {
                response.body().let { contributorInfo ->  contInfo.postValue(contributorInfo) }
            }
        })
    }

}