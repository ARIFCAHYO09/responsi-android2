package com.example.cahyo.fpandroid.feature.favourite.team

import com.example.cahyo.fpandroid.feature.base.BasePresenter
import com.example.cahyo.fpandroid.feature.base.BaseView
import com.example.cahyo.fpandroid.model.entity.TeamEntity

class FavouriteTeamContract {

    interface Presenter : BasePresenter {
        fun getListFavorite()
    }

    interface View : BaseView {
        fun setViewModel(data: TeamEntity)

        fun notifyDataChange()
    }
}