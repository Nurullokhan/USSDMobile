package com.example.ussdmobile.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ussdmobile.MainFragment
import com.example.ussdmobile.fragments.*

class MainViewPagerAdapter(var itemList: List<String>, fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun createFragment(position: Int): Fragment {

        var fragment = Fragment()

        when (position) {
            0 -> {
                fragment = BeelineFragment()
            }
            1 -> {
                fragment = UzmobileFragment()
            }
            2 -> {
                fragment = MobiuzFragment()
            }
            3 -> {
                fragment = UcellFragment()
            }
        }

        return fragment
    }
}