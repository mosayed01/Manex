package com.mosayed.manex.di

import com.mosayed.manex.domain.transactions.ITransactionsUseCase
import com.mosayed.manex.domain.transactions.TransactionsUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    @ViewModelScoped
    abstract fun bindTransactionsUseCas(
        impl: TransactionsUseCase
    ): ITransactionsUseCase
}