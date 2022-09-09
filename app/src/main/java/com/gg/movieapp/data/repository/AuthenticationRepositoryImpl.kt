package com.gg.movieapp.data.repository

import com.gg.movieapp.base.BaseRepository
import com.gg.movieapp.data.AuthenticationRepository
import com.gg.movieapp.data.model.*
import com.gg.movieapp.data.source.AuthenticationDataSource
import com.gg.movieapp.utils.DataResult

class AuthenticationRepositoryImpl(
    private val remote: AuthenticationDataSource.Remote
) : BaseRepository(), AuthenticationRepository {

    override suspend fun login(requestBody: LoginRequestBody): DataResult<LoginResponse> =
        withResultContext {
            remote.login(requestBody)
        }

    override suspend fun getSession(requestBody: SessionRequestBody): DataResult<SessionResponse> =
        withResultContext {
            remote.getSession(requestBody)
        }

    override suspend fun getRequestToken(): DataResult<RequestTokenResponse> =
        withResultContext {
            remote.getRequestToken()
        }
}