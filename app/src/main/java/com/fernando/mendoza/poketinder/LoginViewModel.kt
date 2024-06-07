package com.fernando.mendoza.poketinder

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel(
    val context: Context
): ViewModel() {

    private var sharedPreferencesRepository = SharedPreferencesRepository().also {
            it.setSharedPreferences(context)
        }
    val inputsError = MutableLiveData<Boolean>()
    val loginSuccess = MutableLiveData<Boolean>()
    val authError = MutableLiveData<Boolean>()
    fun validateInputs(email: String, password: String) {
        if (isEmptyInputs(email, password)) {
            inputsError.postValue(true)
            return
        }
        val emailSharedPreferences = sharedPreferencesRepository.getUserEmail()
        val passwordSharedPreferences = sharedPreferencesRepository.getUserPassword()
        if (email == emailSharedPreferences && password == passwordSharedPreferences){
            loginSuccess.postValue(true)
        } else {
            authError.postValue(true)
        }
    }

    fun isEmptyInputs(email: String, password: String) = email.isEmpty() || password.isEmpty()
}
