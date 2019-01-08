package com.example.cahyo.fpandroid.feature.team.player

import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.example.cahyo.fpandroid.R.layout.activity_player_detail
import com.example.cahyo.fpandroid.feature.base.BasePagerAdapter
import com.example.cahyo.fpandroid.helper.loadImageUrl
import com.example.cahyo.fpandroid.model.Constant
import com.example.cahyo.fpandroid.model.vo.PlayerVo
import kotlinx.android.synthetic.main.activity_player_detail.*

class PlayerDetailActivity : AppCompatActivity() {

    lateinit var playerName: String
    private lateinit var basePagerAdapter: BasePagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_player_detail)
        val player: PlayerVo = intent.getParcelableExtra(Constant.PLAYER_INTENT)

        playerName = player.name.orEmpty()
        setContent(player)

        img_player_banner.loadImageUrl(player.banner ?: player.banner1 ?: player.thumbImageUrl.orEmpty())
        app_bar_player.addOnOffsetChangedListener(titleShownOnCollapse(collapsing_toolbar_player))
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    private fun titleShownOnCollapse(collapsingToolbarLayout: CollapsingToolbarLayout):
            AppBarLayout.OnOffsetChangedListener {

        return object : AppBarLayout.OnOffsetChangedListener {
            var isShow = true
            var scrollRange = -1

            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.totalScrollRange
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbarLayout.title = playerName
                    isShow = true
                } else if (isShow) {
                    collapsingToolbarLayout.title = " "
                    isShow = false
                }
            }
        }
    }

    private fun setContent(player: PlayerVo) {
        val content = Bundle()
        content.putParcelable(Constant.PLAYER_INTENT,player)

        val plaOverviewFragment = PlayerOverviewFragment()
        plaOverviewFragment.arguments = content

        basePagerAdapter = BasePagerAdapter(supportFragmentManager)
        basePagerAdapter.let {
            it.addFragment("", plaOverviewFragment)
            view_pager_player.adapter = it
        }
    }
}