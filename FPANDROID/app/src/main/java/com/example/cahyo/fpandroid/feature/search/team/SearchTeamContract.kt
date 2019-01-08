package com.example.cahyo.fpandroid.feature.search.team

import com.example.cahyo.fpandroid.feature.base.BasePresenter
import com.example.cahyo.fpandroid.feature.base.BaseView
import com.example.cahyo.fpandroid.model.response.ListResponse
import com.example.cahyo.fpandroid.model.response.Team

class SearchTeamContract {

    interface View : BaseView {
        fun setViewModel(data: ListResponse<Team>)

        fun search(query: String)
    }

    interface Presenter : BasePresenter {
        fun searchTeams(query: String)
    }
}