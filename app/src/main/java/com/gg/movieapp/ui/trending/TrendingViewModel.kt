package com.gg.movieapp.ui.trending

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gg.movieapp.base.BaseViewModel
import com.gg.movieapp.data.MovieRepository
import com.gg.movieapp.data.model.MovieResponse
import com.gg.movieapp.utils.Constant

class TrendingViewModel(
    private val movieRepository: MovieRepository
) : BaseViewModel() {

    private var _movieList: MutableLiveData<MovieResponse> = MutableLiveData()
    val moviesList: LiveData<MovieResponse> get() = _movieList

    private var _gettingTrendingMovies: MutableLiveData<Boolean> = MutableLiveData()
    val gettingTrendingMovies: LiveData<Boolean> get() = _gettingTrendingMovies

    init {
        getTrendingMovies()
    }

    private fun getTrendingMovies() {
        launchTaskSync(
            onRequest = {
                _gettingTrendingMovies.postValue(true)
                movieRepository.getTrending()
            },
            onSuccess = {
                _gettingTrendingMovies.postValue(false)
                _movieList.postValue(it)
            },
            onError = {
                _gettingTrendingMovies.postValue(false)
            }
        )
    }
}
