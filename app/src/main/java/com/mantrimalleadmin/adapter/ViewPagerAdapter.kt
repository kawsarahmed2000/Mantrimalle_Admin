package com.mantrimalleadmin.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mantrimalleadmin.fragments.recharge
import com.mantrimalleadmin.fragments.withdrawl

class ViewPagerAdapter(fragmentManager: FragmentManager,lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
     return   when(position){
            0->{
                withdrawl()
            }
            1->{
                recharge()
            }
            else->{
                Fragment()
            }

        }
    }
}