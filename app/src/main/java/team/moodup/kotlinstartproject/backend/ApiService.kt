package team.moodup.kotlinstartproject.backend

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import team.moodup.kotlinstartproject.model.WeatherResult

interface ApiService{
    @GET("/")
    fun getWeather(@Query("q") city : String) : Single<WeatherResult>
}