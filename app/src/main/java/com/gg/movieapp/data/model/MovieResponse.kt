package com.gg.movieapp.data.model

data class MovieResponse(
    val page: Int,
    val total_pages: Int,
    val total_results: Int,
    val results: List<Movie>
)
