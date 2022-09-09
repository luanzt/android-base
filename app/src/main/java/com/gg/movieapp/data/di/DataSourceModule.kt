package com.gg.movieapp.data.di

import com.gg.movieapp.data.source.*
import com.gg.movieapp.data.source.remote.*
import org.koin.dsl.module

val DataSourceModule = module {
    single<MovieDataSource.Remote> { MovieTrendingRemoteImpl(get()) }

    single<AuthenticationDataSource.Remote> { AuthenticationRemoteImpl(get()) }
}
