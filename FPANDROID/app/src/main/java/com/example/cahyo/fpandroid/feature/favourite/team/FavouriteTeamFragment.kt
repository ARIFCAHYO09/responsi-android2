package com.example.cahyo.fpandroid.feature.favourite.team

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cahyo.fpandroid.R
import com.example.cahyo.fpandroid.feature.HomeActivity
import com.example.cahyo.fpandroid.feature.adapter.TeamAdapter
import com.example.cahyo.fpandroid.feature.base.BaseFragment
import com.example.cahyo.fpandroid.feature.team.detail.TeamDetailActivity
import com.example.cahyo.fpandroid.helper.invisible
import com.example.cahyo.fpandroid.helper.mapper
import com.example.cahyo.fpandroid.model.Constant
import com.example.cahyo.fpandroid.model.entity.TeamEntity
import com.example.cahyo.fpandroid.model.vo.TeamVo
import com.airbnb.lottie.LottieAnimationView
import kotlinx.android.synthetic.main.fragment_favourite.view.*
import kotlinx.android.synthetic.main.progress_bar.view.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.support.v4.ctx
import javax.inject.Inject

class FavouriteTeamFragment : BaseFragment<FavouriteTeamContract.Presenter>(), FavouriteTeamContract.View {

    @Inject
    internal lateinit var presenter: FavouriteTeamContract.Presenter
    private lateinit var progressBar: LottieAnimationView
    private lateinit var recycleView: RecyclerView
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var favoriteTeamAdapter: TeamAdapter
    private var listOfTeam = mutableListOf<TeamVo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        HomeActivity.menu?.getItem(HomeActivity.MENU_SEARCH)?.invisible()
    }

    override fun getPresenter(): FavouriteTeamContract.Presenter? = presenter

    override fun onInitView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_favourite, container, false)
        recycleView = view.rv_favorite
        swipeRefresh = view.base_swipe_refresh
        progressBar = view.base_progress_bar_id
        recycleView.layoutManager = LinearLayoutManager(ctx)
        favoriteTeamAdapter = TeamAdapter(ctx, listOfTeam) { position ->
            ctx.startActivity<TeamDetailActivity>(
                    Constant.TEAM_INTENT to listOfTeam[position])
        }

        recycleView.adapter = favoriteTeamAdapter
        loadFavorite()

        swipeRefresh.setOnRefreshListener {
            loadFavorite()
        }

        return view
    }

    override fun onResume() {
        super.onResume()
        loadFavorite()
    }

    override fun setViewModel(data: TeamEntity) {
        val teamVo = mapper.map(data, TeamVo::class.java)
        if (data.teamId != null && !listOfTeam.contains(teamVo)) {
            listOfTeam.add(teamVo)
        }
    }

    override fun notifyDataChange() {
        favoriteTeamAdapter.notifyDataSetChanged()
    }

    private fun loadFavorite() {
        listOfTeam.clear()
        presenter.getListFavorite()
    }

    override fun getProgressBar(): LottieAnimationView? = progressBar


    override fun hideLoading() {
        swipeRefresh.isRefreshing = false
        super.hideLoading()
    }

}
