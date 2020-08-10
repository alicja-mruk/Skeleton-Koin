package team.moodup.kotlinstartproject.backend

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import team.moodup.kotlinstartproject.model.Weather
import team.moodup.kotlinstartproject.model.WeatherResult

interface ApiService{

    @Headers("Content-Type: application/json")
    @GET("weather")
    fun getWeather(@Query("q") city : String) : Single<WeatherResult>
}