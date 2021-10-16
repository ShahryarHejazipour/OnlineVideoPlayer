package com.tispunshahryar960103.aparatmovies.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter


class HomeAdapter(fm:FragmentManager,lifecycle:Lifecycle,var fragmentList1:List<Fragment>): FragmentStateAdapter(fm,lifecycle) {


   // private val fragmentList= List<Fragment>()
    private val fragmentList2= ArrayList<Fragment>()

    init {
        fragmentList1=fragmentList2
    }

   /* private fun <T> List(): List<Fragment> {
        return fragmentList
    }*/

    override fun getItemCount(): Int {

        return fragmentList2.size
    }

    override fun createFragment(position: Int): Fragment {

        return fragmentList2[position]


    }


}