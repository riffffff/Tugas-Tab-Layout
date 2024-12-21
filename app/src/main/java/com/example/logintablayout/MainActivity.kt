package com.example.logintablayout

import android.os.Build
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.logintablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        @StringRes
        private val tabName = intArrayOf(
            R.string.tab_text_2,  // No need to repeat package name
            R.string.tab_text_1
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)  // Fixed binding initialization
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = ContextCompat.getColor(this, R.color.black)
        }

        with(binding) {
            setSupportActionBar(toolbar)

            viewPager.adapter = SectionsPagerAdapter(this@MainActivity)  // Fixed adapter initialization

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = getString(tabName[position])
            }.attach()
        }
    }
}
