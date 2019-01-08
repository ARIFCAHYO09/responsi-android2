package com.example.cahyo.fpandroid.feature.event.match

import com.example.cahyo.fpandroid.feature.base.BasePresenter
import com.example.cahyo.fpandroid.feature.base.BaseView
import com.example.cahyo.fpandroid.model.response.Event
import com.example.cahyo.fpandroid.model.response.League
import com.example.cahyo.fpandroid.model.response.ListResponse

class MatchContract {

    interface Presenter : BasePresenter {

        fun getAllLeague()

        fun getLastMatch()

        fun getNextMatch()
    }

    interface View : BaseView {
        fun getSelectedLeagueId(): String?

        fun setLeagues(leagueResponse: ListResponse<League>?)

        fun setViewModel(eventResponse: ListResponse<Event>?)
    }
}