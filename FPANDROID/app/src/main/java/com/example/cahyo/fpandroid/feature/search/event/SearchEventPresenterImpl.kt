package com.example.cahyo.fpandroid.feature.search.event

import com.example.cahyo.fpandroid.feature.base.BaseIdleListener
import com.example.cahyo.fpandroid.feature.base.BasePresenterImpl
import com.example.cahyo.fpandroid.model.Constant
import com.example.cahyo.fpandroid.model.response.ListResponse
import com.example.cahyo.fpandroid.network.TheSportDBApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class SearchEventPresenterImpl @Inject constructor(
        private val idleListener: BaseIdleListener,
        private val view: SearchEventContract.View,
        private val apiService: TheSportDBApiService)
    : BasePresenterImpl(), SearchEventContract.Presenter {

    override fun searchMatches(query: String) {
        super.addDisposable(apiService.searchEvents(query)
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
                .onErrorReturn { ListResponse() }
                .subscribe {
                    view.setViewModel(it)
                })
    }
}