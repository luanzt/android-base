package com.gg.movieapp.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gg.movieapp.base.BaseViewModel
import com.gg.movieapp.data.AuthenticationRepository
import com.gg.movieapp.data.model.LoginRequestBody
import com.gg.movieapp.data.model.SessionRequestBody

class LoginViewModel(
    private val authenticationRepository: AuthenticationRepository
) : BaseViewModel() {

    private var _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> get() = _loading

    private var _loginSuccess: MutableLiveData<Boolean> = MutableLiveData()
    val loginSuccess: LiveData<Boolean> get() = _loginSuccess

    fun getRequestToken(username: String, password: String) {
        launchTaskSync(
            onRequest = {
                _loading.postValue(true)
                authenticationRepository.getRequestToken()
            },
            onSuccess = {
                if (it.success) {
                    loginWithCredential(username, password, it.request_token)
                }
            },
            onError = {
                _loading.postValue(false)
            })
    }

    private fun loginWithCredential(username: String, password: String, token: String) {
        launchTaskSync(
            onRequest = {
                _loading.postValue(true)
                authenticationRepository.login(LoginRequestBody(username, password, token))
            },
            onSuccess = {
                if (it.success) {
                    getSession(it.request_token)
                }
            },
            onError = {
                _loading.postValue(false)
            })
    }

    private fun getSession(requestToken: String) {
        launchTaskSync(
            onRequest = {
                authenticationRepository.getSession(SessionRequestBody(requestToken))
            },
            onSuccess = {
                _loading.postValue(false)
                _loginSuccess.postValue(true)
            },
            onError = {
                _loading.postValue(false)
            })
    }
}
