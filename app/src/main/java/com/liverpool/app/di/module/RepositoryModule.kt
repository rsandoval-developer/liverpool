package com.liverpool.app.di.module

import com.liverpool.app.data.reposotoryimplementations.LiverpoolRepositoryImpl
import com.liverpool.app.domain.repositoryabstractions.LiverpoolRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideLiverpoolRepository(liverpoolRepositoryImpl: LiverpoolRepositoryImpl): LiverpoolRepository =
        liverpoolRepositoryImpl

}