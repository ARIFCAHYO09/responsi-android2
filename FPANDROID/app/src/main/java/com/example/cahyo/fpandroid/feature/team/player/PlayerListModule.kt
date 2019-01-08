package com.example.cahyo.fpandroid.feature.team.player

import com.example.cahyo.fpandroid.di.scope.ActivityScope
import dagger.Binds
import dagger.Module

@Module
abstract class PlayerListModule {


    @ActivityScope
    @Binds
    internal abstract fun provideMainView(playerListFragment: PlayerListFragment) : PlayerListContract.View

    @ActivityScope
    @Binds
    internal abstract fun provideMainPresenter(playerListPresenterImpl: PlayerListPresenterImpl) : PlayerListContract.Presenter
}