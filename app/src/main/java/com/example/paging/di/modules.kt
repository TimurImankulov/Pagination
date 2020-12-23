package com.example.paging.di


import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import com.example.paging.data.interactors.PagingInteractor
import com.example.paging.data.interactors.PagingInteractorImpl
import com.example.paging.data.remote.RetrofitBuilder
import com.example.paging.data.remote.SharesService
import com.example.paging.data.repositories.PagingRepository
import com.example.paging.data.repositories.PagingRepositoryImpl
import com.example.paging.ui.main.MainViewModel


val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}

val repositoryModule = module {
    single<PagingRepository> { PagingRepositoryImpl(get()) }
}

val apiModule = module {
    single { RetrofitBuilder.buildRetrofit() }
    single<PagingInteractor> { PagingInteractorImpl(get()) }
}

val appModules = listOf(viewModelModule, apiModule, repositoryModule)