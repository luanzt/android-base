package com.gg.movieapp.ui.login

import android.app.Activity
import android.content.*
import android.view.View
import com.gg.movieapp.R
import com.gg.movieapp.base.BaseActivityViewBinding
import com.gg.movieapp.databinding.LoginActivityBinding
import com.gg.movieapp.utils.extension.hide
import com.gg.movieapp.utils.extension.show
import com.gg.movieapp.utils.extension.showToast
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivityViewBinding<LoginActivityBinding>(LoginActivityBinding::inflate),
    View.OnClickListener {

    private val loginViewModel: LoginViewModel by viewModel()

    override fun init() {
        initEvent()
        observeItem()
    }

    private fun observeItem() {
        loginViewModel.apply {
            loading.observe(this@LoginActivity) {
                binding?.apply {
                    if (it) {
                        loadingView.root.show()
                    } else {
                        loadingView.root.hide()
                    }
                }
            }
            loginSuccess.observe(this@LoginActivity) {

            }
        }
    }

    private fun initEvent() {
        binding?.apply {
            btnLogin.setOnClickListener(this@LoginActivity)
        }
    }

    companion object {
        fun getIntent(startActivity: Activity) = Intent(startActivity, LoginActivity::class.java)
    }

    private fun handleLogin() {
        binding?.apply {
            if (edtUsername.text.trim() == "" || edtPassword.text.trim() == "") {
                showToast("Username and password are required")
            } else {
                loginViewModel.apply {
                    getRequestToken(
                        edtUsername.text.toString(),
                        edtPassword.text.toString()
                    )
                }
            }
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_login -> handleLogin()
        }
    }
}
