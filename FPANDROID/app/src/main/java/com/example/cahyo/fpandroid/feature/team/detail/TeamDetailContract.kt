package com.example.cahyo.fpandroid.feature.event.detail

import com.example.cahyo.fpandroid.feature.base.BasePresenter
import com.example.cahyo.fpandroid.feature.base.BaseView
import com.example.cahyo.fpandroid.model.entity.TeamEntity

class TeamDetailContract {

    interface Presenter : BasePresenter {

        fun insertTeamToFavorite(teamEntity: TeamEntity)

        fun isExistFavoriteTeam(teamId: String?)

        fun deleteMatchFromFavorite(teamId: String?)
    }

    interface View : BaseView {

        fun isExistFavoriteTeam(isFavorite: Boolean)

        fun getTeamId(): String?
    }
}