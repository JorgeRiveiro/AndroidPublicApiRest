package com.jriveiro.publicapirest.service

import com.jriveiro.publicapirest.model.api.ContributorInfo
import com.jriveiro.publicapirest.model.api.Contributors
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path
import retrofit2.http.Query

interface ContributorApiService {
    @GET("contributors")
    fun getContributorsList():Call<List<Contributors>>

    @GET("/users/{user}")
    fun getContributorInfo(@Path("user") user: String): Call<ContributorInfo>
}