package com.example.cahyo.fpandroid.feature.favourite.team

import com.example.cahyo.fpandroid.di.scope.ActivityScope
import dagger.Binds
import dagger.Module

@Module
abstract class FavouriteTeamModule {

    @ActivityScope
    @Binds
    abstract fun provideFavoriteTeamFragment(favouriteTeamFragment: FavouriteTeamFragment): FavouriteTeamContract.View

    @ActivityScope
    @Binds
    abstract fun provideFavoriteTeamPresenter(favouriteTeamPresenterImpl: FavouriteTeamPresenterImpl): FavouriteTeamContract.Presenter
}