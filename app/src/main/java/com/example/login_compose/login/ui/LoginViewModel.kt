package com.example.login_compose.login.ui

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay


class LoginViewModel : ViewModel() {


    private val _email = MutableLiveData<String>()
    val email = _email

    private val _password = MutableLiveData<String>()
    val password = _password

    private val _loginEnabled = MutableLiveData<Boolean>()
    val loginEnabled = _loginEnabled

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading = _isLoading



    fun onLoginChanged(email: String, password: String) {
        _email.value = email
        _password.value=password
        _loginEnabled.value = isValidEmail(email) && isValidPassword(password)
    }


    private fun isValidEmail(email: String): Boolean = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isValidPassword(password: String): Boolean  = password.length > 6


    suspend fun onLoginSelected() {
        _isLoading.value = true
        delay(4000)
        _isLoading.value = false

    }
}