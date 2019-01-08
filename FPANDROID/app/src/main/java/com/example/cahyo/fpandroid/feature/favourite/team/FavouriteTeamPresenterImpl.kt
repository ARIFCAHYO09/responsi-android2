package com.example.cahyo.fpandroid.feature.favourite.team

import com.example.cahyo.fpandroid.feature.base.BaseIdleListener
import com.example.cahyo.fpandroid.feature.base.BasePresenterImpl
import com.example.cahyo.fpandroid.model.Constant
import com.example.cahyo.fpandroid.model.entity.TeamEntity
import com.example.cahyo.fpandroid.repository.FavoriteTeamRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class FavouriteTeamPresenterImpl @Inject constructor(
        private val idleListener: BaseIdleListener,
        private val view: FavouriteTeamContract.View,
        private val favoriteRepository: FavoriteTeamRepository
) : BasePresenterImpl(), FavouriteTeamContract.Presenter {

    override fun getListFavorite() {
        return super.addDisposable(favoriteRepository.findAll()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    view.showLoading()
                    idleListener.increment()
                }
                .doOnTerminate {
                    view.hideLoading()
                    idleListener.decrement()
                }
                .doOnError { view.showMessage(Constant.FAILED_GET_DATA) }
                .onErrorReturn { TeamEntity() }
                .doOnComplete {
                    view.hideLoading()
                    view.notifyDataChange()
                }
                .subscribe { view.setViewModel(it) })
    }

}