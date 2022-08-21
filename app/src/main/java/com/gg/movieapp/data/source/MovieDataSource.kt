package com.gg.movieapp.data.source

import com.gg.movieapp.data.model.MovieResponse

interface MovieDataSource {
    interface Remote {
        suspend fun getTrendingMovies(): MovieResponse
    }
}