package com.example.cahyo.fpandroid.feature.event.detail

import com.example.cahyo.fpandroid.feature.base.BasePresenter
import com.example.cahyo.fpandroid.feature.base.BaseView
import com.example.cahyo.fpandroid.model.entity.EventEntity
import com.example.cahyo.fpandroid.model.response.Event
import com.example.cahyo.fpandroid.model.response.Team

class MatchDetailContract {

    interface Presenter : BasePresenter {

        fun getDetailEvent()

        fun insertMatchToFavorite(eventEntity: EventEntity)

        fun isExistFavoriteEvent(eventId: String?)

        fun deleteMatchFromFavorite(eventId: String?)
    }

    interface View : BaseView {

        fun isExistFavoriteEvent(isFavorite: Boolean)

        fun getEventId(): String?

        fun setEventDetailModel(event: Event)

        fun setTeamDetailModel(team: Team)
    }
}