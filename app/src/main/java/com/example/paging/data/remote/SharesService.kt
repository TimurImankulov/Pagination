package com.example.paging.data.remote

import com.example.paging.data.model.BasePagingModel
import com.example.paging.data.model.Data
import retrofit2.http.GET
import retrofit2.http.Query

interface SharesService {

    @GET("eod")
    suspend fun getShares(
        @Query("access_key") apiKey: String,
        @Query("symbols") symbols: String,
        @Query("sort") sort: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): BasePagingModel<Data>
}