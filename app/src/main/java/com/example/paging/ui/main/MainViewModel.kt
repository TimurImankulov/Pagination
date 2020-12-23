package com.example.paging.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paging.common.BaseDataSource
import com.example.paging.common.BasePagedViewModel
import com.example.paging.data.model.BasePagingModel
import com.example.paging.data.model.Data
import com.example.paging.data.repositories.PagingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.runBlocking

class MainViewModel(private val repository: PagingRepository) :
    BasePagedViewModel<Data, MainViewModel.MainDataSource>() {

    override val sourceFactory by lazy {
        BaseDataSource.Factory {
            MainDataSource(viewModelScope)
        }
    }

    val data = getPagedList()

    inner class MainDataSource(
        scope: CoroutineScope
    ) : BaseDataSource<Data>(scope) {

        override fun getListByPageNumber(offset: Int, limit: Int): BasePagingModel<Data>? {
            return runBlocking {
                return@runBlocking repository.loadData(offset = offset, limit = limit)

            }
        }
    }
}