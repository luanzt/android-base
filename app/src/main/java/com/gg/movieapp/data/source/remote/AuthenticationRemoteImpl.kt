package com.gg.movieapp.data.source.remote

import com.gg.movieapp.data.model.*
import com.gg.movieapp.data.source.AuthenticationDataSource
import com.gg.movieapp.data.source.remote.api.ApiService

class AuthenticationRemoteImpl(private val apiService: ApiService) :
    AuthenticationDataSource.Remote {
    override suspend fun login(requestBody: LoginRequestBody): LoginResponse {
        return apiService.login(requestBody)
    }

    override suspend fun getSession(requestBody: SessionRequestBody): SessionResponse {
        return apiService.getSession(requestBody)
    }

    override suspend fun getRequestToken(): RequestTokenResponse {
        return apiService.getRequestToken()
    }
}