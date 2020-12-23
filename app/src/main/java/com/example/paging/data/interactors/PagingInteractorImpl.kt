package com.example.paging.data.interactors

import com.example.paging.data.model.BasePagingModel
import com.example.paging.data.model.Data
import com.example.paging.data.remote.SharesService

interface PagingInteractor {
    suspend fun loadData(limit: Int, offset: Int): BasePagingModel<Data>
}

class PagingInteractorImpl(private val service: SharesService) : PagingInteractor {

    override suspend fun loadData(limit: Int, offset: Int): BasePagingModel<Data> {
        return service.getShares(
            apiKey = "c06ea77867714c7b46d31197cc5d5d67",
            symbols = "AAPL",
            sort = "DESC",
            limit = limit,
            offset = offset
        )
    }
}