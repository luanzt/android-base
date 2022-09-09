package com.gg.movieapp.data.di

import com.gg.movieapp.data.*
import com.gg.movieapp.data.repository.*
import com.gg.movieapp.data.source.*
import com.gg.movieapp.data.source.remote.*
import org.koin.dsl.module

val RepositoryModule = module {
    single { provideMovieRepository(MovieTrendingRemoteImpl(get())) }

    single { provideAuthenticationRepository(AuthenticationRemoteImpl(get())) }
}

fun provideMovieRepository(remote: MovieDataSource.Remote): MovieRepository =
    MovieRepositoryImpl(remote)

fun provideAuthenticationRepository(remote: AuthenticationDataSource.Remote): AuthenticationRepository =
    AuthenticationRepositoryImpl(remote)