package team.moodup.kotlinstartproject.backend

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import team.moodup.weatherapp.model.WeatherResult

interface ApiService{
    @GET("{q}")
    fun getWeather(@Path("q") city : String) : Single<WeatherResult>
}