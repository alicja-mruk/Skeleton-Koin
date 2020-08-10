package team.moodup.kotlinstartproject.backend
import retrofit2.Response
import team.moodup.kotlinstartproject.model.WeatherResult

class ApiClient(private val apiService: ApiService) : ApiClientInterface {
    override suspend fun getWeather(city: String): Response<WeatherResult> {
        return apiService.getWeather(city)
    }
}