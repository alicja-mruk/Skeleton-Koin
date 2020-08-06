package team.moodup.kotlinstartproject.backend.repository

import io.reactivex.Single
import org.koin.sampleapp.util.rx.SchedulerProvider
import team.moodup.kotlinstartproject.backend.ApiService
import team.moodup.weatherapp.model.WeatherResult

class WeatherRepositoryImpl(private val apiService: ApiService, private val schedulersProvider: SchedulerProvider) :
    WeatherRepository {
  override fun getWeather(city: String): Single<WeatherResult> {
        return apiService.getWeather(city)
            .subscribeOn(schedulersProvider.io())
            .observeOn(schedulersProvider.ui())
    }
}