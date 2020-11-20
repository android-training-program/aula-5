package pt.atp.bobi.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _loginResult = MutableLiveData<Boolean>()
    val loginResultLiveData = _loginResult

    fun areCredentialsValid(username: String, password: String) {

        // ir ao servidor

        loginResultLiveData.postValue(username == password)
    }
}