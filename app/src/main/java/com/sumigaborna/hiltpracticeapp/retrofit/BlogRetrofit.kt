package com.sumigaborna.hiltpracticeapp.retrofit

import com.sumigaborna.hiltpracticeapp.retrofit.BlogNetworkEntity
import retrofit2.http.GET

interface BlogRetrofit {

    @GET("blogs")
    suspend fun get(): List<BlogNetworkEntity>
}