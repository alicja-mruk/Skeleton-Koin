package team.moodup.kotlinstartproject.backend

import io.reactivex.Single
import org.koin.sampleapp.util.rx.SchedulerProvider
import team.moodup.kotlinstartproject.model.WeatherResult

class ApiClient(private val apiService: ApiService, private val schedulersProvider: SchedulerProvider) : ApiClientInterface {
  override fun getWeather(city: String): Single<WeatherResult> {
        return apiService.getWeather(city)
            .subscribeOn(schedulersProvider.io())
            .observeOn(schedulersProvider.ui())
    }
}