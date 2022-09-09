package com.gg.movieapp.data.model

data class LoginResponse(
    val success: Boolean,
    val expires_at: String,
    val request_token: String
)
