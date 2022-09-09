package com.gg.movieapp.di

import com.gg.movieapp.ui.login.LoginViewModel
import com.gg.movieapp.ui.main.MainViewModel
import com.gg.movieapp.ui.trending.TrendingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val ViewModelModule: Module = module {
    viewModel { MainViewModel() }
    viewModel { TrendingViewModel(get()) }
    viewModel { LoginViewModel(get()) }
}
