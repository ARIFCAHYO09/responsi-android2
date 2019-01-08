package com.example.cahyo.fpandroid.feature.favourite.event

import com.example.cahyo.fpandroid.di.scope.ActivityScope
import dagger.Binds
import dagger.Module

@Module
abstract class FavouriteEventModule {

    @ActivityScope
    @Binds
    abstract fun provideFavoriteTeamFragment(favouriteEventFragment: FavouriteEventFragment): FavouriteEventContract.View

    @ActivityScope
    @Binds
    abstract fun provideFavoriteEventPresenter(favouriteEventPresenterImpl: FavouriteEventPresenterImpl): FavouriteEventContract.Presenter
}