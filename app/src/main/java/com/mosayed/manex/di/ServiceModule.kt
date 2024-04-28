package com.mosayed.manex.di

import com.mosayed.manex.data.transactions.TransactionsRemoteService
import com.mosayed.manex.domain.transactions.ITransactionsRemoteService
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {

    @Binds
    @Singleton
    abstract fun bindTransactionsRemoteService(
        impl: TransactionsRemoteService
    ): ITransactionsRemoteService
}