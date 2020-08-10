package team.moodup.kotlinstartproject.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import team.moodup.kotlinstartproject.backend.ApiClientInterface
import team.moodup.kotlinstartproject.model.WeatherResult
import team.moodup.kotlinstartproject.state.State

class WeatherViewModel(api: ApiClientInterface) : BaseViewModel(api) {
    var stateLiveData = MutableLiveData<State>()
    var weatherLiveData = MutableLiveData<WeatherResult>()

    fun getWeather(city: String) {
        stateLiveData.postValue(State.LOADING)
        viewModelScope.launch {
            val response = api.getWeather(city)
            if (response.isSuccessful) {
                weatherLiveData.postValue(response.body())
                stateLiveData.postValue(State.ON_RESULT)
            }
            else {
                stateLiveData.postValue(State.ON_ERROR)
            }
        }
    }
}