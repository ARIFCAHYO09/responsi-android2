package com.example.cahyo.fpandroid.feature.event.detail

import com.example.cahyo.fpandroid.feature.base.BaseIdleListener
import com.example.cahyo.fpandroid.feature.base.BasePresenterImpl
import com.example.cahyo.fpandroid.model.entity.TeamEntity
import com.example.cahyo.fpandroid.repository.FavoriteTeamRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class TeamDetailPresenterImpl @Inject constructor(
        private val idleListener: BaseIdleListener,
        private val view: TeamDetailContract.View,
        private val favoriteRepository: FavoriteTeamRepository)
    : BasePresenterImpl(), TeamDetailContract.Presenter {

    companion object {
        const val FAILED_ADD_TO_FAVORITE = "Failed add to favorite"
        const val ADDED_TO_FAVORITE = "Added to favorite"
        const val FAILED_TO_REMOVE_FROM_FAVORITE = "Failed to remove from favorite"
        const val REMOVED_FROM_FAVORITE = "Removed from favorite"
        const val FAILED_GET_DATA_FROM_DB = "Failed get data from db"
    }

    override fun insertTeamToFavorite(teamEntity: TeamEntity) {
        super.addDisposable(favoriteRepository.insert(teamEntity)
                .doOnSubscribe {
                    view.showLoading()
                    idleListener.increment()
                }
                .doAfterTerminate {
                    view.hideLoading()
                    idleListener.decrement()
                }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { view.showMessage(FAILED_ADD_TO_FAVORITE) }
                .doOnSuccess { view.showMessage(ADDED_TO_FAVORITE) }
                .subscribe())
    }

    override fun deleteMatchFromFavorite(teamId: String?) {
        super.addDisposable(favoriteRepository.delete(teamId.orEmpty())
                .doOnSubscribe {
                    view.showLoading()
                    idleListener.increment()
                }
                .doAfterTerminate {
                    view.hideLoading()
                    idleListener.decrement()
                }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { view.showMessage(FAILED_TO_REMOVE_FROM_FAVORITE) }
                .doOnSuccess { view.showMessage(REMOVED_FROM_FAVORITE) }
                .subscribe())
    }

    override fun isExistFavoriteTeam(teamId: String?) {
        super.addDisposable(favoriteRepository.isExist(teamId.orEmpty())
                .doOnSubscribe {
                    view.showLoading()
                    idleListener.increment()
                }
                .doAfterTerminate {
                    view.hideLoading()
                    idleListener.decrement()
                }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError { view.showMessage(FAILED_GET_DATA_FROM_DB) }
                .doOnSuccess { i -> view.isExistFavoriteTeam(i) }
                .subscribe())
    }
}