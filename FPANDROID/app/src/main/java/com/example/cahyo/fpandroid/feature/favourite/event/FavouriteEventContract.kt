package com.example.cahyo.fpandroid.feature.favourite.event

import com.example.cahyo.fpandroid.feature.base.BasePresenter
import com.example.cahyo.fpandroid.feature.base.BaseView
import com.example.cahyo.fpandroid.model.entity.EventEntity

class FavouriteEventContract {

    interface Presenter : BasePresenter {
        fun getListFavorite()
    }

    interface View : BaseView {
        fun setViewModel(data: EventEntity)

        fun notifyDataChange()
    }
}