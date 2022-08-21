package com.gg.movieapp.data.repository

import com.gg.movieapp.base.BaseRepository
import com.gg.movieapp.data.MovieRepository
import com.gg.movieapp.data.model.MovieResponse
import com.gg.movieapp.data.source.MovieDataSource
import com.gg.movieapp.utils.DataResult

class MovieRepositoryImpl(
    private val remote: MovieDataSource.Remote
) : BaseRepository(), MovieRepository {

    override suspend fun getTrending(): DataResult<MovieResponse> =
        withResultContext {
            remote.getTrendingMovies()
        }

}