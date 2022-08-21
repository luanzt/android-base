package com.gg.movieapp.data.source.remote.api

import com.gg.movieapp.BuildConfig
import com.gg.movieapp.data.model.*
import retrofit2.http.GET

interface ApiService {
    @GET("trending/all/day?api_key=${BuildConfig.API_KEY}")
    suspend fun getTrendingMovies(): MovieResponse
}
