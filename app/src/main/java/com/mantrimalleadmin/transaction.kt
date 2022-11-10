package com.mantrimalleadmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.mantrimalleadmin.adapter.TransactionViewPagerAdapter
import com.mantrimalleadmin.adapter.ViewPagerAdapter
import com.mantrimalleadmin.databinding.ActivityTransactionBinding

class transaction : AppCompatActivity() {
    private lateinit var binding:ActivityTransactionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        tabLayout()
    }

    private fun tabLayout() {

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager_2)

        val adapter = TransactionViewPagerAdapter(this.supportFragmentManager, lifecycle)
        viewPager2.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Transactions"
                }
                1 -> {
                    tab.text = "Settlements"
                }
            }
        }.attach()

    }

}