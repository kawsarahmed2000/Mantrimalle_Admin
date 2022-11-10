package com.mantrimalleadmin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.mantrimalleadmin.adapter.ViewPagerAdapter
import com.mantrimalleadmin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var navView: NavigationView
    private lateinit var binding: ActivityMainBinding
    lateinit var drawerLayout  : DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tablLayout()
        navView= findViewById(R.id.nav_view)
        drawerLayout = findViewById(R.id.drawer_layout)
        val headerView: View = navView.getHeaderView(0)
        val closeBtn = headerView.findViewById<ImageView>(R.id.backBtnLogin)
        closeBtn.setOnClickListener {
            drawerLayout .closeDrawer(GravityCompat.START);
        }



        binding.sideBarOpenBtn.setOnClickListener {
            drawerLayout .openDrawer(GravityCompat.START);
        }

        navView.setNavigationItemSelectedListener {
            drawerLayout.closeDrawer(GravityCompat.START)
            when(it.itemId){
                R.id.nav_user -> {
                    startActivity(Intent(this,users::class.java))
//                    Toast.makeText(applicationContext, "User", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_game -> {
                    startActivity(Intent(this,game::class.java))
                }
                R.id.nav_transaction ->{

                    startActivity(Intent(this,transaction::class.java))
                }
                R.id.nav_settings -> {
                    withdraw()
//                    Toast.makeText(applicationContext, "Settings", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_admin ->{
                    startActivity(Intent(this,admin::class.java))
                }
                R.id.nav_logout -> {
                    startActivity(Intent(this,login::class.java))
                }
            }
            true
        }
    }

    fun withdraw(){
        val view: View = layoutInflater.inflate(R.layout.settings_bottom_sheet,null)
        val dialog = BottomSheetDialog(this,R.style.BottomSheetDialogTheme)

        val update = view.findViewById<TextView>(R.id.updateSettings)
        val lowerSettings = view.findViewById<TextView>(R.id.lowerSettings)
        val randomSettings = view.findViewById<TextView>(R.id.randomSettings)
        val numberOfBetsSettings = view.findViewById<EditText>(R.id.numberOfBetsSettings)
        val upi = view.findViewById<EditText>(R.id.upiIdSettings)

        numberOfBetsSettings.visibility=View.GONE
        lowerSettings.setOnClickListener {
            numberOfBetsSettings.visibility=View.VISIBLE
        }
        randomSettings.setOnClickListener {
            numberOfBetsSettings.visibility=View.GONE
        }
        update.setOnClickListener {
            Toast.makeText(applicationContext, upi.text.toString(), Toast.LENGTH_SHORT).show()
            dialog.hide()
        }


        dialog.setContentView(view)
        dialog.setCancelable(false)
        dialog.show()
    }
    override fun onResume() {
        super.onResume()
        navView.setCheckedItem(0)

    }

    private fun tablLayout() {

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager_2)

        val adapter = ViewPagerAdapter(this.supportFragmentManager, lifecycle)
        viewPager2.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Withdrawl"
                }
                1 -> {
                    tab.text = "Recharge"
                }
            }
        }.attach()

    }
}