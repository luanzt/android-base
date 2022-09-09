package com.gg.movieapp.data

import com.gg.movieapp.data.model.*
import com.gg.movieapp.utils.DataResult

interface AuthenticationRepository {
    suspend fun login(requestBody: LoginRequestBody): DataResult<LoginResponse>

    suspend fun getSession(requestBody: SessionRequestBody): DataResult<SessionResponse>

    suspend fun getRequestToken(): DataResult<RequestTokenResponse>
}