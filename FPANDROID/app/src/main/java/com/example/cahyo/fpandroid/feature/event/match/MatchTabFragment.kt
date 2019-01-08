package com.example.cahyo.fpandroid.feature.event.match

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.*
import com.example.cahyo.fpandroid.R
import com.example.cahyo.fpandroid.feature.base.BasePagerAdapter
import com.example.cahyo.fpandroid.model.Constant
import com.example.cahyo.fpandroid.model.Constant.MATCH_PREV_MATCH

class MatchTabFragment : Fragment() {

    private lateinit var tabLayout:TabLayout
    private lateinit var viewPager: ViewPager
    private lateinit var viewPagerAdapter: BasePagerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_tabs, container, false)
        tabLayout = view.findViewById(R.id.tabs)
        viewPager = view.findViewById(R.id.viewpager)

        viewPagerAdapter = childFragmentManager.let {
            BasePagerAdapter(it)
        }
        viewPagerAdapter.let {
            it.addFragment(getString(R.string.tab_title_next), MatchFragment.newInstance(Constant.MATCH_NEXT_MATCH))
            it.addFragment(getString(R.string.tab_title_prev), MatchFragment.newInstance(Constant.MATCH_PREV_MATCH))
            viewPager.adapter = it
            tabLayout.setupWithViewPager(viewPager)
            setHasOptionsMenu(true)
        }
        return view
    }
}