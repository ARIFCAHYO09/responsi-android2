package com.example.cahyo.fpandroid.di.component

import android.app.Application
import com.example.cahyo.fpandroid.di.AppController
import com.example.cahyo.fpandroid.di.module.AppModule
import com.example.cahyo.fpandroid.di.module.builder.ActivityBuilder
import com.example.cahyo.fpandroid.di.scope.ApplicationScope
import com.example.cahyo.fpandroid.network.TheSportDBApiService
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule



@ApplicationScope
@Component(modules = [
    AndroidInjectionModule::class,
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBuilder::class])
interface AppComponent : AndroidInjector<AppController> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun theSportDBApiService(): TheSportDBApiService
}