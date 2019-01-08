package com.example.cahyo.fpandroid.repository

import android.app.Application
import com.example.cahyo.fpandroid.di.scope.ApplicationContext
import com.example.cahyo.fpandroid.di.scope.ApplicationScope
import com.example.cahyo.fpandroid.helper.database
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @ApplicationScope
    @Provides
    internal fun provideDatabaseHelper(@ApplicationContext application: Application): DatabaseUtils {
        return application.database
    }

    @ApplicationScope
    @Provides
    internal fun provideFavoriteEventRepository(databaseUtils: DatabaseUtils): FavouriteMatchRepository {
        return FavouriteMatchRepositoryImpl(databaseUtils)
    }

    @ApplicationScope
    @Provides
    internal fun provideFavoriteTeamRepository(databaseUtils: DatabaseUtils): FavoriteTeamRepository {
        return FavoriteTeamRepositoryImpl(databaseUtils)
    }
}