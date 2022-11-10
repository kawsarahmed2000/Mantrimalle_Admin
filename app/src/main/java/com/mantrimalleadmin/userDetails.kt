package com.mantrimalleadmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.mantrimalleadmin.adapter.UserDetailsViewPagerAdapter
import com.mantrimalleadmin.adapter.ViewPagerAdapter
import com.mantrimalleadmin.databinding.ActivityUserDetailsBinding

class userDetails : AppCompatActivity() {
    private lateinit var binding: ActivityUserDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityUserDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tabLayout()
    }

    private fun tabLayout() {

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager_2)

        val adapter = UserDetailsViewPagerAdapter(this.supportFragmentManager, lifecycle)
        viewPager2.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Withdrawl"
                }
                1 -> {
                    tab.text = "Recharge"
                }
                2 -> {
                    tab.text = "Game History"
                }
                3 -> {
                    tab.text = "Reffer"
                }
            }
        }.attach()

    }
}