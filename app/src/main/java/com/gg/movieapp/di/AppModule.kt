package com.gg.movieapp.di

import com.gg.movieapp.utils.dispatchers.BaseDispatcherProvider
import com.gg.movieapp.utils.dispatchers.DispatcherProvider
import org.koin.dsl.module

val AppModule = module {
    single { provideBaseDispatcherProvider() }
}

fun provideBaseDispatcherProvider(): BaseDispatcherProvider {
    return DispatcherProvider()
}
