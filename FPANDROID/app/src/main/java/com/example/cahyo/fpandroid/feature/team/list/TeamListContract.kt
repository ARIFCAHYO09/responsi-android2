package com.example.cahyo.fpandroid.feature.team.list

import com.example.cahyo.fpandroid.feature.base.BasePresenter
import com.example.cahyo.fpandroid.feature.base.BaseView
import com.example.cahyo.fpandroid.model.response.League
import com.example.cahyo.fpandroid.model.response.ListResponse
import com.example.cahyo.fpandroid.model.response.Team

class TeamListContract {

    interface Presenter : BasePresenter {

        fun getLeagueList()

        fun getTeamList(leagueName: String)
    }

    interface View : BaseView {

        fun leagueName() : String

        fun showTeamList(teamResponse: ListResponse<Team>?)

        fun getListLaugue(leagueResponse: ListResponse<League>?)
    }
}