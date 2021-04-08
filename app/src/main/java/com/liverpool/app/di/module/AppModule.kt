package com.liverpool.app.di.module

import android.app.Application
import com.liverpool.app.data.services.local.AppPreferences
import dagger.Module
import dagger.Provides
import com.liverpool.app.presentation.utils.ResourceProvider
import com.liverpool.app.presentation.utils.Utils
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideAppUtil(app: Application): Utils = Utils(app)


    @Provides
    @Singleton
    fun provideAppPreferences(app: Application): AppPreferences =
        AppPreferences(app)


    @Provides
    @Singleton
    fun provideResource(app: Application): ResourceProvider = ResourceProvider(app)

}
