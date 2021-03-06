package com.example.cahyo.fpandroid.feature.base

import com.example.cahyo.fpandroid.helper.RxUtils
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenterImpl : BasePresenter {

    private var disposableHolder: CompositeDisposable? = null

    override fun onAttach() {
        initDisposableHolder()
    }

    override fun onDetach() {
        if (RxUtils.isDisposableInitialized(this.disposableHolder)) {
            RxUtils.disposeComposite(this.disposableHolder)
        }
    }

    private fun initDisposableHolder() {
        if (!RxUtils.isDisposableInitialized(this.disposableHolder)) {
            this.disposableHolder = CompositeDisposable()
        }
    }

    fun addDisposable(disposable: Disposable) {
        initDisposableHolder()
        this.disposableHolder?.add(disposable)
    }
}
