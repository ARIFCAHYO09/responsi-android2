package com.example.cahyo.fpandroid.feature.team.player

import com.example.cahyo.fpandroid.feature.base.BasePresenter
import com.example.cahyo.fpandroid.feature.base.BaseView
import com.example.cahyo.fpandroid.model.response.ListResponse
import com.example.cahyo.fpandroid.model.response.Player

class PlayerListContract {

    interface View : BaseView {

        fun setPlayerViewModel(players: ListResponse<Player>)
    }

    interface Presenter : BasePresenter {
        fun getListTeamPlayer(teamId: String)
    }
}