package com.example.cahyo.fpandroid.feature.favourite.event

import com.example.cahyo.fpandroid.feature.base.BaseIdleListener
import com.example.cahyo.fpandroid.feature.base.BaseIdleResource
import com.example.cahyo.fpandroid.feature.base.BasePresenterImpl
import com.example.cahyo.fpandroid.model.Constant
import com.example.cahyo.fpandroid.model.entity.EventEntity
import com.example.cahyo.fpandroid.repository.FavouriteMatchRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class FavouriteEventPresenterImpl @Inject constructor(
        private val idleListener: BaseIdleListener,
        private val view: FavouriteEventContract.View,
        private val favouriteRepository: FavouriteMatchRepository
) : BasePresenterImpl(), FavouriteEventContract.Presenter {

    override fun getListFavorite() {
        return super.addDisposable(favouriteRepository.findAll()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    view.showLoading()
                    idleListener.increment()
                }
                .doOnError { view.showMessage(Constant.FAILED_GET_DATA) }
                .onErrorReturn { EventEntity() }
                .doOnComplete {
                    view.hideLoading()
                    view.notifyDataChange()
                    idleListener.decrement()
                }
                .subscribe { view.setViewModel(it) })
    }

}