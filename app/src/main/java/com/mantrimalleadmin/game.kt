package com.mantrimalleadmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mantrimalleadmin.databinding.ActivityGameBinding

class game : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backBtnUsers.setOnClickListener {
            finish()
        }
    }
}