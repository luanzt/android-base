package com.gg.movieapp.data.source

import com.gg.movieapp.data.model.*

interface AuthenticationDataSource {
    interface Remote {
        suspend fun login(requestBody: LoginRequestBody): LoginResponse

        suspend fun getSession(requestBody: SessionRequestBody): SessionResponse

        suspend fun getRequestToken(): RequestTokenResponse
    }
}