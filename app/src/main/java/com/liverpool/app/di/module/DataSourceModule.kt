package com.liverpool.app.di.module

import com.liverpool.app.data.datasourceImplementations.api.LiverpoolApiDataSourceImpl
import com.liverpool.app.data.services.api.LiverpoolService
import com.liverpool.app.domain.dataSourceAbstractions.LiverpoolDataSource
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class DataSourceModule {

    @Provides
    @Singleton
    fun provideLiverpoolService(retrofit: Retrofit): LiverpoolService =
        retrofit.create(LiverpoolService::class.java)

    @Provides
    @Singleton
    fun provideLiverpoolDataSource(liverpoolApiDataSourceImpl: LiverpoolApiDataSourceImpl): LiverpoolDataSource =
        liverpoolApiDataSourceImpl

}