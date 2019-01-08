package com.example.cahyo.fpandroid.feature.event.match

import com.example.cahyo.fpandroid.di.scope.ActivityScope
import dagger.Binds
import dagger.Module

@Module
abstract class MatchModule {

    @ActivityScope
    @Binds
    abstract fun provideMatchView(matchFragment: MatchFragment): MatchContract.View

    @ActivityScope
    @Binds
    abstract fun provideMatchPresenter(matchPresenterImpl: MatchPresenterImpl): MatchContract.Presenter
}