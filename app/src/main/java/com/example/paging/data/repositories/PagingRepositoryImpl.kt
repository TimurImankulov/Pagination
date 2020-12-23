package com.example.paging.data.repositories

import com.example.paging.data.interactors.PagingInteractor
import com.example.paging.data.model.BasePagingModel
import com.example.paging.data.model.Data

interface PagingRepository {

    suspend fun loadData(limit: Int, offset: Int): BasePagingModel<Data>

}

class PagingRepositoryImpl(private val network: PagingInteractor) : PagingRepository {

    override suspend fun loadData(limit: Int, offset: Int): BasePagingModel<Data> {
        return network.loadData(limit = limit, offset = offset)
    }

}