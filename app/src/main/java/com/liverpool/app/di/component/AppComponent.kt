package com.liverpool.app.di.component

import android.app.Application
import com.liverpool.app.LiverpoolApplication
import com.liverpool.app.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        DataSourceModule::class,
        RepositoryModule::class,
        ActivityModule::class,
        FragmentModule::class,
        NetworkModule::class,
        AppModule::class]
)
interface AppComponent {

    fun inject(app: LiverpoolApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent

    }

}