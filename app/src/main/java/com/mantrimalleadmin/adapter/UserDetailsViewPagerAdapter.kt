package com.mantrimalleadmin.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mantrimalleadmin.fragments.recharge
import com.mantrimalleadmin.fragments.withdrawl

class UserDetailsViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
     return   when(position){
            0->{
                Fragment()
            }
            1->{
                Fragment()
            }
            3->{
                Fragment()
            }
            4->{
                Fragment()
            }
            else->{
                Fragment()
            }

        }
    }
}