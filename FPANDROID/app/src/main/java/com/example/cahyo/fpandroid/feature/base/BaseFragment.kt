package com.example.cahyo.fpandroid.feature.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cahyo.fpandroid.helper.invisible
import com.example.cahyo.fpandroid.helper.visible
import dagger.android.support.AndroidSupportInjection
import org.jetbrains.anko.design.snackbar

abstract class BaseFragment<out T : BasePresenter> : Fragment(), BaseView {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        this.getPresenter()?.run {
            this.onAttach()
        }

        return onInitView(inflater, container, savedInstanceState)
    }

    abstract fun getPresenter(): T?

    protected abstract fun onInitView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View

    override fun showMessage(message: String) {
        this.view?.rootView?.let {
            snackbar(it, message)
        }
    }

    override fun onDestroy() {
        getPresenter()?.onDetach()
        super.onDestroy()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun showLoading() {
        getProgressBar()?.visible()
    }

    override fun hideLoading() {
        getProgressBar()?.invisible()
    }
}