package com.example.cahyo.fpandroid.di.module.builder

import com.example.cahyo.fpandroid.di.scope.ActivityScope
import com.example.cahyo.fpandroid.feature.event.detail.MatchDetailActivity
import com.example.cahyo.fpandroid.feature.event.detail.MatchDetailModule
import com.example.cahyo.fpandroid.feature.event.detail.TeamDetailModule
import com.example.cahyo.fpandroid.feature.event.match.MatchFragment
import com.example.cahyo.fpandroid.feature.event.match.MatchModule
import com.example.cahyo.fpandroid.feature.favourite.event.FavouriteEventFragment
import com.example.cahyo.fpandroid.feature.favourite.event.FavouriteEventModule
import com.example.cahyo.fpandroid.feature.favourite.team.FavouriteTeamFragment
import com.example.cahyo.fpandroid.feature.favourite.team.FavouriteTeamModule
import com.example.cahyo.fpandroid.feature.search.event.SearchEventFragment
import com.example.cahyo.fpandroid.feature.search.event.SearchEventModule
import com.example.cahyo.fpandroid.feature.search.team.SearchTeamFragment
import com.example.cahyo.fpandroid.feature.search.team.SearchTeamModule
import com.example.cahyo.fpandroid.feature.team.detail.TeamDetailActivity
import com.example.cahyo.fpandroid.feature.team.list.TeamListFragment
import com.example.cahyo.fpandroid.feature.team.list.TeamListModule
import com.example.cahyo.fpandroid.feature.team.player.PlayerListFragment
import com.example.cahyo.fpandroid.feature.team.player.PlayerListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = [TeamListModule::class])
    internal abstract fun provideTeamListActivity() : TeamListFragment

    @ActivityScope
    @ContributesAndroidInjector(modules = [MatchModule::class])
    abstract fun provideMatchFragment(): MatchFragment

    @ActivityScope
    @ContributesAndroidInjector(modules = [MatchDetailModule::class])
    abstract fun provideMatchDetailActvity(): MatchDetailActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [SearchEventModule::class])
    abstract fun provideSearchEvent(): SearchEventFragment

    @ActivityScope
    @ContributesAndroidInjector(modules = [SearchTeamModule::class])
    abstract fun provideSearchTeam(): SearchTeamFragment

    @ActivityScope
    @ContributesAndroidInjector(modules = [FavouriteTeamModule::class])
    abstract fun provideFavoriteTeam(): FavouriteTeamFragment

    @ActivityScope
    @ContributesAndroidInjector(modules = [FavouriteEventModule::class])
    abstract fun provideFavoriteEvent(): FavouriteEventFragment

    @ActivityScope
    @ContributesAndroidInjector(modules = [TeamDetailModule::class])
    abstract fun provideTeamDetailActivity(): TeamDetailActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = [PlayerListModule::class])
    abstract fun providePlayerListFragment(): PlayerListFragment

}