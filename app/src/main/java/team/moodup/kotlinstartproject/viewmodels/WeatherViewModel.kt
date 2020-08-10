package team.moodup.kotlinstartproject.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import team.moodup.kotlinstartproject.backend.ApiClientInterface
import team.moodup.kotlinstartproject.model.WeatherResult

class WeatherViewModel(api: ApiClientInterface) : BaseViewModel(api) {

    var weatherLiveData = MutableLiveData<WeatherResult>()

    fun getWeather(city: String) {
        launch {
            api.getWeather(city)
                .subscribe(
                    { weather->
                        weatherLiveData.postValue(weather)
                    },
                    { e ->
                        println("got error : $e")
                    }
                )
        }
    }

}