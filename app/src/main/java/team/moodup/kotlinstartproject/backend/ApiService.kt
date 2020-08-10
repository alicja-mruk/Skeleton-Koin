package team.moodup.kotlinstartproject.backend


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import team.moodup.kotlinstartproject.model.WeatherResult

interface ApiService{

    @Headers("Content-Type: application/json")
    @GET("weather")
    suspend fun getWeather(@Query("q") city : String) : Response<WeatherResult>
}