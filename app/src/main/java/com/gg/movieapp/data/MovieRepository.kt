package com.gg.movieapp.data

import com.gg.movieapp.data.model.MovieResponse
import com.gg.movieapp.utils.DataResult

interface MovieRepository {
    suspend fun getTrending() : DataResult<MovieResponse>
}