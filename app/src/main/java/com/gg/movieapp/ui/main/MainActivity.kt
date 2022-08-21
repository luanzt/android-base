package com.gg.movieapp.ui.main

import android.app.Activity
import android.content.*
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.gg.movieapp.R
import com.gg.movieapp.base.BaseActivityViewBinding
import com.gg.movieapp.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivityViewBinding<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val mainViewModel: MainViewModel by viewModel()

    override fun init() {
        setUpFragment()
        observeItem()
    }


    private fun setUpFragment() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding?.apply {
            setupWithNavController(bottomNavigationView, navController)
        }
    }

    private fun observeItem() {
        mainViewModel.apply {

        }
    }

    companion object {
        fun getIntent(startActivity: Activity) = Intent(startActivity, MainActivity::class.java)
    }
}
