package com.example.cahyo.fpandroid.feature.search.team

import com.example.cahyo.fpandroid.di.scope.ActivityScope
import dagger.Binds
import dagger.Module

@Module
abstract class SearchTeamModule {

    @ActivityScope
    @Binds
    abstract fun provideSearchTeam(searchTeamFragment: SearchTeamFragment): SearchTeamContract.View

    @ActivityScope
    @Binds
    abstract fun provideSearchPresenter(searchTeamPresenterImpl: SearchTeamPresenterImpl): SearchTeamContract.Presenter
}