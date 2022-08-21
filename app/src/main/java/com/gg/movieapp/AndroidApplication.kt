package com.gg.movieapp

import android.app.Application
import com.gg.movieapp.data.di.DataSourceModule
import com.gg.movieapp.data.di.NetworkModule
import com.gg.movieapp.data.di.RepositoryModule
import com.gg.movieapp.di.AppModule
import com.gg.movieapp.di.ViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.core.context.startKoin

class AndroidApplication : Application() {
    private val rootModule =
        listOf(AppModule, NetworkModule, DataSourceModule, RepositoryModule, ViewModelModule)

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@AndroidApplication)
            androidFileProperties()
            modules(rootModule)
        }
    }
}
