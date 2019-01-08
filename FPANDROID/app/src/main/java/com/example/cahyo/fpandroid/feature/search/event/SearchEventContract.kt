package com.example.cahyo.fpandroid.feature.search.event

import com.example.cahyo.fpandroid.feature.base.BasePresenter
import com.example.cahyo.fpandroid.feature.base.BaseView
import com.example.cahyo.fpandroid.model.response.Event
import com.example.cahyo.fpandroid.model.response.ListResponse

class SearchEventContract {

    interface  View : BaseView {
        fun setViewModel(data: ListResponse<Event>)

        fun search(query: String)
    }

    interface Presenter : BasePresenter {
        fun searchMatches(query: String)
    }
}