package com.gg.movieapp.data.source.remote.api

import com.gg.movieapp.BuildConfig
import com.gg.movieapp.data.model.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("trending/all/day?api_key=${BuildConfig.API_KEY}")
    suspend fun getTrendingMovies(): MovieResponse

    @POST("authentication/token/validate_with_login?api_key=${BuildConfig.API_KEY}")
    suspend fun login(@Body requestBody: LoginRequestBody): LoginResponse

    @POST("authentication/session/new?api_key=${BuildConfig.API_KEY}")
    suspend fun getSession(@Body requestBody: SessionRequestBody): SessionResponse

    @GET("authentication/token/new?api_key=${BuildConfig.API_KEY}")
    suspend fun getRequestToken(): RequestTokenResponse
}
