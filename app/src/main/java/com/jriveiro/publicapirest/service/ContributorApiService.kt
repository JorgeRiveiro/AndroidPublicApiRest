package com.jriveiro.publicapirest.service

import com.jriveiro.publicapirest.model.api.Contributors
import retrofit2.http.GET
import retrofit2.Call

interface ContributorApiService {
    @GET("contributors")
    fun getContributorsList():Call<List<Contributors>>
}