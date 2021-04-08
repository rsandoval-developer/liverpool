package com.liverpool.app.di.module

import com.liverpool.app.presentation.ui.search.SearchActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun bindSearchActivity(): SearchActivity


}