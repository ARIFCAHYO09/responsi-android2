package com.example.cahyo.fpandroid.feature.event.detail

import com.example.cahyo.fpandroid.di.scope.ActivityScope
import com.example.cahyo.fpandroid.feature.team.detail.TeamDetailActivity
import dagger.Binds
import dagger.Module

@Module
abstract class TeamDetailModule {

    @ActivityScope
    @Binds
    abstract fun provideTeamDetailView(teamDetailActivity: TeamDetailActivity): TeamDetailContract.View

    @ActivityScope
    @Binds
    abstract fun provideTeamPresenter(teamDetailPresenterImpl: TeamDetailPresenterImpl): TeamDetailContract.Presenter
}