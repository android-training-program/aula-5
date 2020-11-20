package pt.atp.bobi.presentation

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){

    private val _timerLiveDate = MutableLiveData<Long>()
    val timerLiveDate = _timerLiveDate

    private var timer: CountDownTimer? = null

    fun starTimer(time: Long){
        timer = object : CountDownTimer(time, 1000){
            override fun onTick(millisUntilFinished: Long) {
                _timerLiveDate.postValue(millisUntilFinished / 1000)
            }

            override fun onFinish() {

            }
        }
        timer?.start()
    }
}