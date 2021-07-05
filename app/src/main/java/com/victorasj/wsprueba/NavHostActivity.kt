package com.victorasj.wsprueba

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.victorasj.wsprueba.databinding.ActivityNavHostBinding

class NavHostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavHostBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavHostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
    }

    override fun onBackPressed() {
        finish()
    }
}