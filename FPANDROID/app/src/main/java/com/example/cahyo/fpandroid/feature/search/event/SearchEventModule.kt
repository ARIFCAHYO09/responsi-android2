package com.example.cahyo.fpandroid.feature.search.event

import com.example.cahyo.fpandroid.di.scope.ActivityScope
import dagger.Binds
import dagger.Module

@Module
abstract class SearchEventModule {

    @ActivityScope
    @Binds
    abstract fun provideSearchEvent(searchEventFragment: SearchEventFragment): SearchEventContract.View

    @ActivityScope
    @Binds
    abstract fun provideSearchPresenter(searchEventPresenterImpl: SearchEventPresenterImpl): SearchEventContract.Presenter
}