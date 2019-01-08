package com.example.cahyo.fpandroid.di.module

import android.app.Application
import android.content.Context
import com.example.cahyo.fpandroid.di.scope.ApplicationContext
import com.example.cahyo.fpandroid.di.scope.ApplicationScope
import com.example.cahyo.fpandroid.feature.base.BaseIdleListener
import com.example.cahyo.fpandroid.feature.base.BaseIdleResource
import com.example.cahyo.fpandroid.network.NetworkModule
import com.example.cahyo.fpandroid.repository.RepositoryModule
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module(includes = [NetworkModule::class, RepositoryModule::class])
class AppModule {

    @ApplicationScope
    @Provides
    @ApplicationContext
    internal fun provideApplication(application: Application) : Application {
        return application
    }

    @ApplicationScope
    @Provides
    internal fun provideContext(@ApplicationContext application: Application) : Context {
        return application
    }

    @Provides
    @Reusable
    internal fun provideBaseIdleResource(): BaseIdleListener = BaseIdleResource
}