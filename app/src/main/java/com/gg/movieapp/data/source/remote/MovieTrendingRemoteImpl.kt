package com.gg.movieapp.data.source.remote

import com.gg.movieapp.data.model.MovieResponse
import com.gg.movieapp.data.source.MovieDataSource
import com.gg.movieapp.data.source.remote.api.ApiService

class MovieTrendingRemoteImpl(private val apiService: ApiService) : MovieDataSource.Remote {
    override suspend fun getTrendingMovies(): MovieResponse {
        return apiService.getTrendingMovies()
    }
}