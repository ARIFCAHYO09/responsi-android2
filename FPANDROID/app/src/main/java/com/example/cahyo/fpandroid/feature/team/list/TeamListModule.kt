package com.example.cahyo.fpandroid.feature.team.list

import com.example.cahyo.fpandroid.di.scope.ActivityScope
import dagger.Binds
import dagger.Module

@Module
abstract class TeamListModule {

    @ActivityScope
    @Binds
    internal abstract fun provideTeamListView(listTeamFragment : TeamListFragment) : TeamListContract.View

    @ActivityScope
    @Binds
    internal abstract fun provideTeamListPrenter(listTeamPresenterImpl: TeamListPresenterImpl) : TeamListContract.Presenter

}